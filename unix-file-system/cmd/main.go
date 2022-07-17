package main

import (
	"flag"
	"fmt"
)

type Inode struct {
	Name      string
	Extension string
	Size      int64
}

type NameFilter struct {
	value string
}

func (f *NameFilter) Satisfies(inode Inode) bool {
	return inode.Name == f.value
}

type ExtensionFilter struct {
	value string
}

func (f *ExtensionFilter) Satisfies(inode Inode) bool {
	return inode.Extension == f.value
}

type MinSizeFilter struct {
	value int64
}

func (f *MinSizeFilter) Satisfies(inode Inode) bool {
	return inode.Size >= f.value
}

type MaxSizeFilter struct {
	value int64
}

func (f *MaxSizeFilter) Satisfies(inode Inode) bool {
	return inode.Size <= f.value
}

type Filter interface {
	Satisfies(inode Inode) bool
}

type ComposedFilter struct {
	filters []Filter
}

func (f *ComposedFilter) Satisfies(inode Inode) bool {
	matches := true
	for _, filter := range f.filters {
		matches = matches && filter.Satisfies(inode)
	}
	return matches
}

func NewComposedFilter(name, ext string, minSize, maxSize int64) ComposedFilter {
	filter := ComposedFilter{}
	if name != "" {
		filter.filters = append(filter.filters, &NameFilter{
			value: name,
		})
	}
	if ext != "" {
		filter.filters = append(filter.filters, &ExtensionFilter{
			value: ext,
		})
	}
	if minSize > 0 {
		filter.filters = append(filter.filters, &MinSizeFilter{
			value: minSize,
		})
	}
	if maxSize > 0 {
		filter.filters = append(filter.filters, &MaxSizeFilter{
			value: maxSize,
		})
	}
	return filter
}

func (f *ComposedFilter) Filter(inodes []Inode) []Inode {
	var matches []Inode
	for _, inode := range inodes {
		if f.Satisfies(inode) {
			matches = append(matches, inode)
		}
	}
	return matches
}

func main() {
	name := flag.String("name", "", "Filter for files with the given name")
	ext := flag.String("ext", "", "Filter for files with the given extension")
	minSize := flag.Int64("min-size", 0, "Filter for files with size >= the given size (in bytes)")
	maxSize := flag.Int64("max-size", 0, "Filter for files with size <= the given size (in bytes)")
	flag.Parse()
	filter := NewComposedFilter(*name, *ext, *minSize, *maxSize)
	// TODO: Parse from command line arguments and use unix sys calls to actually get the inodes from the File System
	inodes := []Inode{}
	inodes = append(inodes, Inode{
		Name:      "file1",
		Extension: "txt",
		Size:      122,
	})
	inodes = append(inodes, Inode{
		Name:      "dir1/file1",
		Extension: "go",
		Size:      1032,
	})
	matches := filter.Filter(inodes)
	for _, match := range matches {
		fmt.Printf("%s.%s: %d\n", match.Name, match.Extension, match.Size)
	}
}
