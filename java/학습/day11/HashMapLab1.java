package day11;

import java.util.*;

public class HashMapLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 하나하나꺼내서 입력.. 키만 뽑아내서 넣는게 쉬움
		final int N = 5;
		HashMap<String, Integer> map = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		while (map.size() < N) {
			map.put(sc.next(), sc.nextInt());
			sc.nextLine();
		}
		sc.close();

		System.out.print("입력된 데이터 : ");

		// 쉬운 방법
		Set<String> keySet = map.keySet();//Set 
		Iterator<String> iter = keySet.iterator();

		while (true) {
			String key = iter.next();
			System.out.printf("%s(%d)", key, map.get(key));

			if (iter.hasNext())
				System.out.print(", ");
			else
				break;
		}
	}

}
