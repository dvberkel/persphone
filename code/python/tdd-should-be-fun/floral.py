class Product():
	def __init__(self, name, price):
		self.name = name
		self.price = price

class ShoppingCart():
	def __init__(self,products,*quantities):
		self.products = []
		self.quantities = []
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
		if (product in self.products):
			index = self.products.index(product)
			self.quantities[index] += quantity
		else:
			self.products.append(product)
			self.quantities.append(quantity)
		self.price += quantity * product.price
	
	def Order(self):
		order = FloralOrder()
		for i in range(len(self.products)):
			product = self.products[i]
			quantity = self.quantities[i]
			order.add_order(product,quantity)
		return order


class FloralOrder():
	def __init__(self):
		self.products = []
		self.orderlines = []
		self.amount = 0
	
	def add_order(self,product, quantity):
		self.orderlines.append(product)
		self.amount += quantity * product.price

	def Pay(self,payment):
		self.payed = self.amount <= payment.amount
		drop = min(self.amount, payment.amount);
		payment.remaining = payment.amount - drop
		payment.amount -= drop
		self.amount -= drop

			
class BankPayment():
	def __init__(self,amount):
		self.amount = amount
		self.remaining = 0

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
	assert order.amount == 0, "amount of 0 expected!"

def test6():
	gerbera = Product("Gerbera", 5)
	sunflower = Product("Sunflower", 4)
	vase = Product("Vase", 13)
	shopping_cart = ShoppingCart([gerbera, gerbera, sunflower, sunflower, vase])
	order = shopping_cart.Order()
	order.Pay(BankPayment(20))
	assert not order.payed, "order was payed unexpectedly!"
	assert len(order.orderlines) == 3, "expected 3 orderlines!"
	assert order.amount == 11, "expected an amount of 11!"

def test7():
	flower = Product("Sunflower", 4)
	vase = Product("Vase", 13)
	shopping_cart = ShoppingCart([flower, flower, flower, flower, vase])
	order = shopping_cart.Order()
	payment = BankPayment(31)
	order.Pay(payment)
	assert order.payed, "order not payed!"
	assert len(order.orderlines) == 2, "expected 2 orderlines!"
	assert order.amount == 0, "amount should be 0!"
	assert payment.remaining == 2, "on your payment an amount of 2 should remain!"

if __name__ == '__main__':
	test0()
	test1()
	test2()
	test3()
	test4()
	test5()
	test6()
	test7()
