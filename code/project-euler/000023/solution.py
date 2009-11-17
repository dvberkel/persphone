#! /usr/bin/env python

# Defined in problem 21
def properDivisorSum(n):
	total = 0
	for d in range(1,n):
		if n % d == 0:
			total = total + d
	
	return total

def isAbundant(n):
	return properDivisorSum(n) > n

def abundantNumbers(bound):
	abundant = []
	for number in range(1,bound):
		if isAbundant(number):
			abundant.append(number)
	return abundant	

if __name__ == '__main__':
	bound = 28124
	
	abundant = abundantNumbers(bound)
	
	sums = []
	for x in abundant:
		for y in abundant:
			print str(x) + " " + str(y)
			s = x + y
			if s < bound:
				sums.append(s)
			else:
				break
	
	numbers = range(1,bound)
	for aSum in sums:
		if aSum in numbers:
			numbers.remove(aSum)	
	
	total = 0
	for number in numbers:
		total = total + number
	
	print total
