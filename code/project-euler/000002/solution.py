#! /usr/bin/env python

if __name__ == '__main__':
	bound = 4000000
	
	f0 = 0; f1 = 1; total = 0;
	while (f1 <= bound):
		if (f1 % 2 == 0) :
			total = total + f1
		
		f0, f1 = f1, f0 + f1
	
	print total;	
