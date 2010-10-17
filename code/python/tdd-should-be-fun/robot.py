class Robot():
	def __init__(self):
		self.location = (0,0)

def test0():
	robot = Robot()
	
	assert robot.location == (0,0)
	

if __name__ == '__main__':
	test0()
