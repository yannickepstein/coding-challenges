package main

import "sync"

type HitCounter struct {
	hits []
	l    sync.RWMutex
}

// Hit the counter at the given timestamp
func (c *HitCounter) Hit(timestamp int) {
	c.l.Lock()
	for 
}

// Get hits that happened in the past five minutes from the given timestamp (5 minutes = 300 seconds)
func (c *HitCounter) getHits(timestamp int) {}

// Some observations;
// whenever we get a hit, we need to persist it
// we need to persist it, s.t. we can quickly retrieve all hits made 300 seconds before a given timestamp
//
// A small simplification:
// Assume that we only receive one hit per second, then we can receive the hits in the five minutes before a
// timestamp through a simple linear scan of the last 300 items
//
// If now multiple hits can occur, we will keep track of all hits that occurred at the same timestamp
// Then we sum over them if we receive some timestamp to get the hits from
// (constant space complexity of 300 items)
//
// If multiple hits occur per second concurrently, we will need to synchronize access to the data structure

func main() {}
