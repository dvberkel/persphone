#! /usr/bin/env python

def collatz(n):
	if n == 1:
		return 1
	elif n % 2 == 0:
		return n / 2
	else:
		return 3 * n + 1

def chain(n):
	visited = [n]
	while (n != 1):
		n = collatz(n)
		visited.append(n)
	return visited

if __name__ == '__main__':
	bound = 1000000
	
	candidates = []
	for i in range(bound):
		candidates.append(True)
	candidates[0] = False
	
	number = 0; maxLength = 1
	index = 0
	while index < len(candidates):
		if (candidates[index]):
			visited = chain(index)
			for item in visited:
				if item < len(candidates):
					candidates[item] = False
			if (len(visited) > maxLength):
				number = index
				maxLength = len(visited)
		index = index + 1
		print str(index) + "," + str(number) + "," + str(maxLength)
