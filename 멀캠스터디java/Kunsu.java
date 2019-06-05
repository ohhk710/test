package lol;

public class Kunsu {
	int j = 1;
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> stack = new ArrayList<Integer>(); // 무한수열 스택
	int k = sc.nextInt();
	while (j < k) {
		for(int i=0; i<j;) {
			if (stack.isEmpty()) {
				stack.add(j);
				i++;
			} else {
				stack.add(++i);
			}
		}
		j++;
	}
}
