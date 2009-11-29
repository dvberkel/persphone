#! /usr/bin/env python

def next(permutation):
	index = len(permutation) - 2
	while index >= 0 and permutation[index] > permutation[index + 1]:
		index = index - 1
	if index < 0:
		return None
	else:
		least = len(permutation) - 1
		while permutation[least] < permutation[index]:
			least = least - 1
		(permutation[index], permutation[least]) = (permutation[least], permutation[index])
		return permutation

if __name__ == '__main__':
	permutation = [0, 1, 2]
	
	print permutation
	permutation = next(permutation)
	print permutation
	permutation = next(permutation)
	print permutation

