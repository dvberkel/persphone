#! /usr/bin/env python

def numberOfDivisors(n):
	count = 0
	for number in range(1, n+1):
		if (n % number == 0):
			count = count + 1
	
	return count

def triangleNumber(n):
	return n * (n+1) / 2

if __name__ == '__main__':
	bound = 500
	
	maxDivisors = 1; number = 1
	while maxDivisors < bound:
		print str(number) + " " + str(maxDivisors)
		if (number % 2 == 0):
			a = number / 2
			b = number + 1
		else:
			a = number
			b = (number + 1) / 2
		
		divisorCountA = numberOfDivisors(a)
		divisorCountB = numberOfDivisors(b)
		
		product = divisorCountA * divisorCountB
		if (product > maxDivisors):
			maxDivisors = product
		
		number = number + 1
	
	print triangleNumber(number - 1);
