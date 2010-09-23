#! /usr/bin/env python

from WiredFactory import WiredFactory
import PieceFactory

class Game(WiredFactory):
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
	game = Game()
	assert len(game.playableCells()) == 9
	assert not game.over
	game.play(game.upperLeft)
	game.play(game.middleLeft)
	game.play(game.middleCenter)
	game.play(game.lowerLeft)
	game.play(game.lowerRight)
	assert game.over
	assert len(game.playableCells()) == 0
	
