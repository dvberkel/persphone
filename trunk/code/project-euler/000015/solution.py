#! /usr/bin/env python

if __name__ == '__main__':
	blocks = 20
	bound = blocks + 1	
	
	row = []
	for index in range(bound):
		row.append(0)
	
	grid = []
	for x in range(bound):
		row = []
		for y in range(bound):
			row.append(0)
		grid.append(row)
	
	for index in range(bound):
		grid[0][index] = 1
		grid[index][0] = 1
	
	index = 1;
	while index < len(grid):
		for i in range(1,index + 1):
			grid[i][index] = grid[i - 1][index] + grid[i][index - 1]
			grid[index][i] = grid[index - 1][i] + grid[index][i - 1]
		grid[index][index] = grid[index - 1][index] + grid[index][index - 1]
		index = index + 1
		
	print grid[blocks][blocks]
		
