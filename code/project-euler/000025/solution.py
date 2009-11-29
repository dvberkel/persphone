#! /usr/bin/env python

from math import log

def numberOfDigits(n):
	return int(log(n) / log(10) + 1)

if __name__ == '__main__':
	bound = 1000
	
	f_old = 1
	f_new = 1
	
	count = 2
	while (numberOfDigits(f_new) < bound):
		(f_old, f_new) = (f_new, f_old + f_new)
		count = count + 1
	
	print count
	
	
