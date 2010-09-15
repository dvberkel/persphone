class Product():
	def __init__(self, name, price):
		self.name = name
		self.price = price

class ShoppingCart():
	products = []
	price = 0
	def __init__(self,products):
		if not type(products) is type([]):
			products = [products]
		
		for product in products:
			self.add_product(product,1)
		

	def add_product(self,product, quantity):
		for i in range(quantity):
			self.products.append(product)
			self.price += product.price
			

def test1():
	product = Product("Sunflower", 2)
	assert product.name == "Sunflower"
	assert product.price == 2

def test2():
	flower = Product("Sunflower", 2)
	vase = Product("Vase", 13)
	shopping_cart = ShoppingCart(vase)
	shopping_cart.add_product(flower, 6)
	assert shopping_cart.price == 25, "Shopping cart price not 25!"

def test3():
	flower = Product("Sunflower", 2)
	vase = Product("Vase", 13)
	shopping_cart = ShoppingCart([flower, vase])
	assert flower in shopping_cart.products, "flower not in products!"
	assert vase in shopping_cart.products, "vase not in products!"

if __name__ == '__main__':
	test1()
	test2()
	test3()
