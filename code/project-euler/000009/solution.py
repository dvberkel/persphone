#! /usr/bin/env python

def isTriplet(a,b,c):
	return a**2 + b**2 == c**2;

if __name__ == '__main__':
	bound = 1000
	
	for a in range(1, bound + 1):
		for b in range(a + 1, bound):
			c = bound - (a + b)
			
			if (c < b):
				break

			if isTriplet(a,b,c):
				print a * b * c
