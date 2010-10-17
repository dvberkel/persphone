class Robot():
	def __init__(self):
		self.location = [0,0]
	
	def forward(self):
		self.location[0] += 1
		self.location[1] += 0
		return self

def test0():
	robot = Robot()
	
	assert robot.location == [0,0]

def test1():
	robot = Robot()
	
	robot.forward().forward()
	
	assert robot.location == [2,0]


if __name__ == '__main__':
	test0()
	test1()
