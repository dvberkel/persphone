"Create a prototype for a Mancala game"

Object subclass: Heap [
	|numberOfStones|
	
	addStone [
		self addStones: 1
		^self
	]
	
	removeStone [
		self removeStones: 1
		^self
	]
	
	addStones: number [
		numberOfStones = numberOfStones + number
		^self
	]
	
	removeStones: number [
		numberOfStones = numberOfStones - number
		^self
	]
]
