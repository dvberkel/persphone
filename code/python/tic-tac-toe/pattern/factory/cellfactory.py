#! /usr/bin/env python

from domain.cell import Cell

class CellFactory():
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
		
		self.representations = [
			(self.upperLeft, 'ul'), (self.upperCenter,'uc'), (self.upperRight,'ur'), 
			(self.middleLeft,'ml'), (self.middleCenter,'mc'), (self.middleRight,'mr'), 
			(self.lowerLeft,'ll'), (self.lowerCenter,'lc'), (self.lowerRight,'lr')
		]
	
	def cells(self):
		return map((lambda x: x[0]), self.representations)
	
	def representations(self):
		return map((lambda x: x[1]), self.representations)
	
	def toCell(self,representation):
		return (filter((lambda x: x[1] == representation),self.representations))[0][0]
	
	def toRepresentation(self,cell):
		return (filter((lambda x: x[0] == cell),self.representation))[0][1]

if __name__ == '__main__':
	factory = CellFactory()
	assert len(factory.cells()) == 9
	assert factory.middleCenter == factory.toCell('mc')
	assert 'll' == factory.toRepresentation(factory.lowerLeft)
