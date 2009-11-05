#! /usr/bin/env python


if __name__ == '__main__':
	bound = 2000000
	
	flags = []
	for index in range(bound):
		flags.append(True)
	
	flags[0] = False; index = 1; total = 0;
	while index < len(flags):
		if flags[index]:
			number = index + 1;
			total = total + number
			step = number
			walk = index + step
			while walk < len(flags):
				flags[walk] = False
				walk = walk + step
		index = index + 1
	print total
