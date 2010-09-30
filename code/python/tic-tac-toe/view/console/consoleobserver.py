#!/usr/bin/env python

from pattern.observer import Observer
from pattern.factory import piecefactory
from view.representation import present
from domain.player import RandomPlayer
from domain.interactivegame import InteractiveGame

class ConsoleObserver(Observer):
	def __init__(self):
		pass
			
	def notify(self, observable):
		short = present(observable)
		print short[0:3] + "\n" + short[3:6] + "\n" + short[6:9] + "\n";

if __name__ == '__main__':
	game = InteractiveGame(RandomPlayer(),RandomPlayer())
	game.subscribe(ConsoleObserver())
	game.start()
