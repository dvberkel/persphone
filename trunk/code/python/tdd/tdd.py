class Product():
	def __init__(self, name, price):
		self.name = name
		self.price = price

def test1():
	product = Product("Sunflower", 2)
	assert product.name == "Sunflower"
	assert product.price == 2

if __name__ == '__main__':
	test1()
