#! /usr/bin/env python

def representation(n,b):
	digits = []
	while n > 0:
		digits.append(n % b)
		n = n / b
	
	return digits

def isPalindrome(n):
	digits = representation(n,10)
	
	size = len(digits)
	for index in range(size):
		if digits[index] != digits[(size - 1) - index]:
			return False
	
	return True
	
	
	return 

if __name__ == '__main__':
	interval = range(100,1000)

	maxPalindrome = 1
	for factor1 in interval:
		for factor2 in interval:
			product = factor1 * factor2
			if (isPalindrome(product) and product > maxPalindrome):
				maxPalindrome = product;
	
	print maxPalindrome
