#! /usr/bin/env python

from math import factorial

if __name__ == '__main__':
	number = factorial(100)
	
	total = 0
	while number > 0:
		total = total + (number % 10)
		number = number / 10
	
	print total
