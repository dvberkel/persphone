class Robot():
	def __init__(self):
		self.location = [0,0]
		self.heading = [1,0]
	
	def forward(self):
		self.location[0] += self.heading[0]
		self.location[1] += self.heading[1]
		return self
	
	def left(self):
		self.heading = [-self.heading[1],self.heading[0]]
		return self
	
	def right(self):
		self.heading = [self.heading[1],-self.heading[0]]
		return self

def test0():
	robot = Robot()
	
	assert robot.location == [0,0]

def test1():
	robot = Robot()
	
	robot.forward().forward()
	
	assert robot.location == [2,0]

def test2():
	robot = Robot()
	
	robot.left().forward()
	assert robot.location == [0,1]

	robot.right().forward()
	assert robot.location == [1,1]


if __name__ == '__main__':
	test0()
	test1()
	test2()
