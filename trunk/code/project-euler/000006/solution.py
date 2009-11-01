#! /usr/bin/env python

def sumOfIntegers(n):
	return n * (n+1) / 2

def sumOfSquares(n):
	return n * (n+1) * (2*n+1) / 6;

if __name__ == '__main__':
	n = 100;
	
	print sumOfIntegers(n) ** 2 - sumOfSquares(n);
