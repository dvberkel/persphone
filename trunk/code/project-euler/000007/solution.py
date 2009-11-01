#! /usr/bin/env python

def nextPrime(primes):
	number = primes[-1] + 1;
	
	while True:
		divisible = False
		for prime in primes:
			if (number % prime == 0):
				divisible = True
				break
		
		if (not divisible):
			return number;
		
		number = number + 1;

if __name__ == '__main__':
	bound = 10001
	
	primes = [2]
	while len(primes) < bound:
		prime = nextPrime(primes)
		primes.append(prime);
	
	print primes[-1];
	
