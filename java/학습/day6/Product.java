package day6;

public class Product {
		private String name;
		private int balance = 0;
		private int price = 0;

		public	Product() {
			name = "µàÅ©ÀÎÇü";
			balance = 5;
			price = 10000;
		}

		public	Product(String name, int balance, int price) {
			this.name = name;
			this.balance = balance;
			this.price = price; 
		}

		public	 String getName() {
			return name;
		}

		public	 int getBalance() {
			return balance;
		}

		public	 int getPrice() {
			return price;
		}

	}