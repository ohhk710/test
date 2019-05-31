package day3;

public class WhileLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num510=(int)(Math.random()*6)+5;
		for (int i=1;i<=num510;i++) {
			int JegobFor=i*i;
			System.out.println(i+" -> "+JegobFor);
		}
		System.out.println();
		int j=1;
		while(j<=num510){
			int JegobWhile =j*j;
			System.out.println(j+" -> "+JegobWhile);
			j++;
		}
	}

}
