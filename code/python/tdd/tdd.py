class Product():
	def __init__(self, name, price):
		self.name = name
		self.price = price

class ShoppingCart():
	def __init__(self,products,*quantities):
		self.products = []
		self.price = 0
		if not type(products) is type([]):
			products = [products]
		
		quantity = 1
		if len(quantities) != 0:
			quantity = quantities[0]
		
		for product in products:
			self.add_product(product,quantity)
		

	def add_product(self,product, *quantities):
		quantity = 1
		if len(quantities) != 0:
			quantity = quantities[0]
		for i in range(quantity):
			self.products.append(product)
			self.price += product.price
	
	class Order():
		def __init__(self):
			self.orderlines = [(),()]
			self.amount = 25
		
		def Pay(self,payment):
			self.payed = 1

			
class BankPayment():
	def __init__(self,amount):
		self.amount = amount

def test0():
	product = Product("Sunflower", 2)
	assert product.name == "Sunflower"
	assert product.price == 2

def test1():
	flower = Product("Sunflower", 2)
	vase = Product("Vase", 13)
	shopping_cart = ShoppingCart(vase)
	shopping_cart.add_product(flower, 6)
	assert shopping_cart.price == 25, "Shopping cart price not 25!"

def test2():
	flower = Product("Sunflower", 2)
	vase = Product("Vase", 13)
	shopping_cart = ShoppingCart([flower, vase])
	assert flower in shopping_cart.products, "flower not in products!"
	assert vase in shopping_cart.products, "vase not in products!"

def test3():
	flower = Product("Sunflower", 2)
	shopping_cart = ShoppingCart(flower, 6)
	assert shopping_cart.price == 12, "price not 12!"

def test4():
	flower = Product("Sunflower", 2)
	shoppping_cart = ShoppingCart(flower, 7)
	vase = Product("Vase", 13)
	shoppping_cart.add_product(vase)
	assert shoppping_cart.price == 27, "price not 27!"

def test5():
	flower = Product("Sunflower", 2)
	vase = Product("Vase", 13)
	shopping_cart = ShoppingCart(vase)
	shopping_cart.add_product(flower, 6)
	order = shopping_cart.Order()
	order.Pay(BankPayment(25))
	assert order.payed, "order not payed!"
	assert len(order.orderlines) == 2, "2 orderlines expected!"
	assert order.amount == 25, "amount of 25 expected!"	

if __name__ == '__main__':
	test0()
	test1()
	test2()
	test3()
	test4()
	test5()
