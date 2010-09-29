#! /usr/bin/env python

from wiredfactory import WiredFactory
from domain.piece import piecefactory

class Game(WiredFactory):
	def __init__(self, startPiece):
		WiredFactory.__init__(self)
		self.currentPiece = startPiece
		self.over = False
		self.winner = None
	
	def notify(self,observable):
		self.over = True
		self.winner = observable.leader()
	
	def playableCells(self):
		return filter((lambda c: (not self.over and c.playable())), self.cells())
	
	def play(self,cell):
		assert cell.playable
		cell.place(self.currentPiece)
		self.currentPiece = self.currentPiece.opponent()

if __name__ == '__main__':
	game = Game(piecefactory.nought)
	assert len(game.playableCells()) == 9
	assert not game.over
	assert game.winner == None
	game.play(game.upperLeft)
	game.play(game.middleLeft)
	game.play(game.middleCenter)
	game.play(game.lowerLeft)
	game.play(game.lowerRight)
	assert game.over
	assert len(game.playableCells()) == 0
	assert game.winner == piecefactory.nought
	
