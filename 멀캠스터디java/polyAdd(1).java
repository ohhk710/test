package lol;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coefX = { 1, 1, 1 };
		int[] expX = { 0, 1, 2 };
		int[] coefY = { 1, 1, 1 };
		int[] expY = { 0, 2, 3 };
		int[] result = new int[4];

		int Xpos = 0, Ypos = 0, resultPos = 0;
		// while문 더 나을 때 : 길이 다를때??
		int x = 0, y = 0;
		while (Xpos < expX.length && Ypos < expY.length) {
			if (expX[Xpos] == expY[Ypos]) {

				result[resultPos] = coefX[Xpos] + coefY[Ypos];
				Xpos++;
				Ypos++;
				resultPos++;
			} else if (expX[Xpos] > expY[Ypos]) {
				result[resultPos++] = coefY[Ypos];
				Ypos++;

			} else {
				result[resultPos++] = coefX[Xpos];
				Xpos++;
			}
		}
		for (; Xpos < expX.length; Xpos++) {
			result[resultPos++] = coefY[Xpos];
		}
		for (; Ypos < expY.length; Ypos++) {
			result[resultPos++] = coefY[Ypos];
		}
		
		System.out.print("coef result : ");
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i]+" ");

	}

}
