#! /usr/bin/env python

from WiredFactory import WiredFactory
import PieceFactory

class Board(WiredFactory):
	def __init__(self):
		WiredFactory.__init__(self)
		self.currentPiece = PieceFactory.nought
		self.over = False
	
	def notify(self,observable):
		self.over = True
	
	def playableCells(self):
		return filter((lambda c: (not self.over and c.playable())), self.cells())
	
	def play(self,cell):
		assert cell.playable
		cell.place(self.currentPiece)
		self.currentPiece = self.currentPiece.opponent()

if __name__ == '__main__':
	board = Board()
	assert len(board.playableCells()) == 9
	assert not board.over
	board.play(board.upperLeft)
	board.play(board.middleLeft)
	board.play(board.middleCenter)
	board.play(board.lowerLeft)
	board.play(board.lowerRight)
	assert board.over
	assert len(board.playableCells()) == 0
	
