package lol;

import java.util.ArrayList;
import java.util.Arrays;

public class sort {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		for (int data : solution(array, commands))
			System.out.println(data);
		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// 배열크기모르면 arraylist로 
		///배열은 사용하고자 하는 크기만큼 먼저 할당하고 
		//arraylist는 필요할때마다 할당 =빈리스트부터가능
		
		int first = 0, second = 0, third = 0;
		int answer[] = {};
		for (int i = 0; i < commands.length; i++) {
			first = commands[i][0];
			second = commands[i][1];
			third = commands[i][2];

			//int newAryLength = second - first + 1;
			//변수 만드는것보다 그냥 하는게 더 나을수도
			int[] tmp = new int[second - first + 1];
			int newAryIndex = 0;
			for (int j = first - 1; j <= second - 1; j++) {
				tmp[newAryIndex++] = array[j]; //자른 범위를 배열에 넣음
			}
			Arrays.sort(tmp);// collections.sort(name)
			arr.add(tmp[third - 1]);//k번째 수 찾아서 arr 넣음
		}
		//리스트에 있는 숫자를 answer크기 맞춰서 잘라서 넣음
		answer = new int[arr.size()];
		for (int j = 0; j < arr.size(); j++) {
			answer[j] = arr.get(j);
		}
		return answer;
	}
}
