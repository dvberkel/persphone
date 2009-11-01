#! /usr/bin/env python

from math import sqrt, floor

def primeDivisors(n):
	divisors = []
	
	number = 2; bound = floor(sqrt(n))
	while (number < bound):
		if (n % number == 0):
			while (n % number == 0):
				n = n / number
			divisors.append(number)
		number = number + 1
	
	return divisors
	

if __name__ == '__main__':
	number = 600851475143
	
	divisors = primeDivisors(number)
	print divisors
