#! /usr/bin/env python

def properDivisorSum(n):
	total = 0
	for d in range(1,n):
		if n % d == 0:
			total = total + d
	
	return total

def isAmicable(m):
	n = properDivisorSum(m)
	if (m == properDivisorSum(n)):
		return [min(m,n),max(m,n)]
	else:
		return None

def amicablePairs(bound):
	amicable = []
	for number in range(1,bound):
		pair = isAmicable(number)
		if pair and not (pair[0] == pair[1]) and not (pair in amicable):
			amicable.append(pair)
	return amicable

if __name__ == '__main__':
	bound = 10000

	amicable = amicablePairs(bound)
	
	total = 0
	for pair in amicable:
		total = total + pair[0] + pair[1]
	
	print total
	
