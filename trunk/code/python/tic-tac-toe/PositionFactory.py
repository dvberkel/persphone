#! /usr/bin/env python

from Position import UL, UC, UR, ML, MC, MR, LL, LC, LR

class PositionFactory:
	upperLeft = UL()
	upperCenter = UC()
	upperRight = UR()
	middleLeft = ML()
	middleCenter = MC()
	middleRight = MR()
	lowerLeft = LL()
	lowerCenter = LC()
	lowerRight = LR()

if __name__ == '__main__':
	assert PositionFactory.upperLeft
