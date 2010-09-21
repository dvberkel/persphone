#! /usr/bin/env python

from Cell import Cell

class Board():
	def __init__(self):
		self.cells = [Cell() : i in range(9)]

	def __get__(self, index):
		return self.cells[index].piece
	
	def __set__(self, index, content):
		pass
		
if __name__ == '__main__':
	assert Board()
