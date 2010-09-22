#! /usr/bin/env python

from Cell import Cell

class PositionFactory():
	def __init__(self):
		self.upperLeft = Cell()
		self.upperCenter = Cell()
		self.upperRight = Cell()
		self.middleLeft = Cell()
		self.middleCenter = Cell()
		self.middleRight = Cell()
		self.lowerLeft = Cell()
		self.lowerCenter = Cell()
		self.lowerRight = Cell()

if __name__ == '__main__':
	positions = PositionFactory()
	assert positions.upperLeft
