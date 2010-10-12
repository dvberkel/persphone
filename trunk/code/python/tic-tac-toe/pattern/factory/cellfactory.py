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
			Representation(self.upperLeft, 'ul'), Representation(self.upperCenter,'uc'), Representation(self.upperRight,'ur'), 
			Representation(self.middleLeft,'ml'), Representation(self.middleCenter,'mc'), Representation(self.middleRight,'mr'), 
			Representation(self.lowerLeft,'ll'), Representation(self.lowerCenter,'lc'), Representation(self.lowerRight,'lr')
		]
	
	def cells(self):
		return map((lambda x: x.cell), self.representations)
	
	def representations(self):
		return map((lambda x: x.name), self.representations)
	
	def toCell(self,name):
		return (filter((lambda x: x.name == name),self.representations))[0].cell
	
	def toRepresentation(self,cell):
		return (filter((lambda x: x.cell == cell),self.representations))[0].name

class Representation():
		def __init__(self,cell,name):
			self.cell = cell
			self.name = name

if __name__ == '__main__':
	factory = CellFactory()
	assert len(factory.cells()) == 9
	assert factory.middleCenter == factory.toCell('mc')
	assert 'll' == factory.toRepresentation(factory.lowerLeft)
