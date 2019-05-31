package day6;



public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product[] pd = new Product[5];

		pd[0] = new Product();
		pd[1] = new Product("피카츄인형", 3, 30000);
		pd[2] = new Product("파이리인형", 3, 3000);
		pd[3] = new Product("꼬부기인형", 3, 3000);
		pd[4] = new Product("라이츄인형", 3, 3000);

		for (Product data : pd) {
			System.out.printf("상품이름 : %s 재고량 : %d 가격 :%,d원\n", data.getName(), data.getBalance(), data.getPrice());
		}
	}
}
