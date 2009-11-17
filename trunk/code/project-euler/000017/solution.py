#! /usr/bin/env python

def numberName(n):
	return "one"

if __name__ == '__main__':
	numbers = [1,2,3,4,5,6,7,8,9,10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
	
	for number in numbers:
		print str(number) + " : " + numberName(number)
