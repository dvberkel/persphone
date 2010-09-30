#!/usr/bin/env python

from pattern.factory import piecefactory
from domain.game import Game

_symbolFor = {piecefactory.nought:'O', piecefactory.cross:'X', piecefactory.empty:'_'}

def present(game):
	return reduce((lambda x,y: x + y),map((lambda y: _symbolFor[y]),map((lambda x: x.piece),game.cells())))


if __name__ == '__main__':
	game = Game(piecefactory.nought)
	assert present(game) == '_________'

