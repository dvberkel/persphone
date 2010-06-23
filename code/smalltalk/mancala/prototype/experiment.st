"Create a prototype for a Mancala game"

Object subclass: Heap [
	|numberOfStones|
	
	numberOfStones [
		^numberOfStones
	]
	
	addStone [
		self addStones: 1.
		^self
	]
	
	removeStone [
		self removeStones: 1.
		^self
	]
	
	addStones: aNumberOfStones [
		numberOfStones = numberOfStones + aNumberOfStones.
		^self
	]
	
	removeStones: aNumberOfStones [
		self numberOfStones >= aNumberOfStones ifTrue: [
			numberOfStones = numberOfStones - aNumberOfStones.
		] ifFalse: [
			self error: 'this heap does not contain that many stones'.
		].
		^self
	]
	
	receiveAStoneFrom: aHeap [
		aHeap removeStone.
		self addStone.
		^self
	]
	
	receiveAllStonesFrom: aHeap [
		[aHeap numberOfStones > 0] whileTrue: [self receiveAStoneFrom aHeap]
	]
]

Object subclass: Bowl [
	|heap nextBowl|
	
	getHeap [
		^heap
	]
	
	getNextBowl [
		^nextBowl
	]
	
	receiveHeap: aHeap [
		self getHeap receiveAStoneFrom: aHeap.
		aHeap numberOfStones > 0 ifTrue: [
			self getNextBowl receiveHeap: aHeap.
		].
	]	
]
