#! /usr/bin/env python

def sumOfDigits(n):
	total = 0
	while n != 0:
		total = total + (n % 10)
		n = n / 10 
	return total

if __name__ == '__main__':
	number = 2**1000
	
	print sumOfDigits(number)
