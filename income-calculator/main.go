package main

import (
	"fmt"
)

type SimpleDate struct {
	Month int
	Year  int
}

func Now() SimpleDate {
	return SimpleDate{
		Month: 7,
		Year:  2022,
	}
}

type YearIncome struct {
	Year   int
	Income float64
}

type Contract struct {
	Start  SimpleDate
	Base   int
	Rsu    int
	SignOn int
}

func Income(c Contract) []YearIncome {
	now := Now()
	years := now.Year - c.Start.Year + 1
	monthlyBase := float64(c.Base) / 12.0
	monthlyRsu := float64(c.Rsu) / 12.0
	var incomes []YearIncome
	if years > 1 {
		firstYearMonths := 12 - c.Start.Month + 1
		firstYearIncome := float64(firstYearMonths)*monthlyBase + float64(firstYearMonths)*monthlyRsu + float64(c.SignOn)
		incomes = append(incomes, YearIncome{
			Year:   c.Start.Year,
			Income: firstYearIncome,
		})
	}
	for year := c.Start.Year + 1; year < now.Year; year++ {
		incomes = append(incomes, YearIncome{
			Year:   year,
			Income: float64(c.Base) + float64(c.Rsu),
		})
	}
	if now.Year == c.Start.Year {
		currentYearMonths := now.Month - c.Start.Month + 1
		currentYearIncome := float64(currentYearMonths)*monthlyBase + float64(currentYearMonths)*monthlyRsu + float64(c.SignOn)
		incomes = append(incomes, YearIncome{
			Year:   now.Year,
			Income: currentYearIncome,
		})
	} else {
		currentYearIncome := float64(now.Month)*monthlyBase + float64(now.Month)*monthlyRsu
		incomes = append(incomes, YearIncome{
			Year:   now.Year,
			Income: currentYearIncome,
		})
	}
	return incomes
}

func main() {
	c := Contract{
		Base:   120000,
		Rsu:    60000,
		SignOn: 25000,
		Start: SimpleDate{
			Year:  2018,
			Month: 02,
		},
	}
	incomes := Income(c)
	for _, income := range incomes {
		fmt.Printf("%d: %v\n", income.Year, income.Income)
	}
}
