#! /usr/bin/env python

def gcd(a,b):
	if (a % b == 0):
		return b
	else:
		return gcd(b, a % b)

def lcm(a,b):
	return a*b / gcd(a,b)
	

def lcmOfList(a):
	if len(a) == 1:
		return a[0]
	elif len(a) == 2:
		return lcm(a[0],a[1])
	else:
		result = lcm(a[0], a[1])
		return lcmOfList([result] + a[2:])
	

if __name__ == '__main__':
	print lcmOfList(range(1,21));
	
