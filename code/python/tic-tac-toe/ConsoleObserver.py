#!/usr/bin/env python

from pattern.observer.Observer import Observer
from domain.piece import PieceFactory
from Player import RandomPlayer
from InteractiveGame import InteractiveGame

class ConsoleObserver(Observer):
	def __init__(self):
		self.symbolFor = {PieceFactory.nought:'O', PieceFactory.cross:'X', PieceFactory.empty:'_'}
	
	def notify(self, observable):
		short = reduce((lambda x,y: x + y),map((lambda y: self.symbolFor[y]),map((lambda x: x.piece),observable.cells())))
		print short[0:3] + "\n" + short[3:6] + "\n" + short[6:9] + "\n";

if __name__ == '__main__':
	game = InteractiveGame(RandomPlayer(),RandomPlayer())
	game.subscribe(ConsoleObserver())
	game.start()
