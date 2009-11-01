#! /usr/bin/env python

if __name__ == '__main__':
	bound = 1000
	
	number = 0; total = 0
	while (number < bound):
		if (number % 3 == 0) or (number % 5 == 0):
			total = total + number
		number = number + 1;
	
	print total
	
