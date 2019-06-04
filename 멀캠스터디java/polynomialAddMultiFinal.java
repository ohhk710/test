package lol;

public class gg {
	public static void main(String[] args) {
		polynomial();
	}

	public static void polynomial() {
		float[] a_coef = { 1, 1 };
		int[] a_exp = { 1, 0 };

		float[] b_coef = { 5, -10, 5, -10 };
		int[] b_exp = { 3, 2, 1, 0 };

		Polynomial a = new Polynomial();
		Polynomial b = new Polynomial();
		
		Polynomial result;

		for (int i = 0; i < a_exp.length; i++) {
			a.newTerm(a_coef[i], a_exp[i]);
		}
		for (int i = 0; i < b_exp.length; i++) {
			b.newTerm(b_coef[i], b_exp[i]);
		}
		result = a.add(b);
		System.out.print("다항식 a + 다항식 b = ");
		result.print();

		result = a.Mul(b);
		System.out.print("다항식 a * 다항식 b = ");
		result.print();
	}
}

class Term {
	float coef;
	int exp;

	Term() {
		this.coef = 0;
		this.exp = 0;
	}
}

class Polynomial {
	Term termArray[];
	int terms;

	public Polynomial() {
		this.terms = 0;
		this.termArray = new Term[10];
		for (int i = 0; i < termArray.length; i++) {
			termArray[i] = new Term();
		}
	}

	void print() {
		String result = "";
		for (int i = 0; i < this.termArray.length; i++) {
			if (this.termArray[i].coef == 0) {
				continue;
			} else {
				if (i != 0) {
					result = result + " + " + this.termArray[i].coef + "x^" + this.termArray[i].exp;
				} else {
					result = this.termArray[i].coef + "x^" + this.termArray[i].exp;
				}
			}
		}
		if (result == "")
			System.out.println("0");
		else
			System.out.println(result);
	}

	void newTerm(float coef, int exp) {
		if (this.termArray.length == this.terms) {
			Term temp[] = new Term[this.termArray.length * 2];
			for (int i = 0; i < this.termArray.length; i++) {
				temp[i] = termArray[i];
			}
			this.termArray = temp;
		}
		this.termArray[this.terms].coef = coef;
		this.termArray[this.terms++].exp = exp;
	}
	
	Polynomial add(Polynomial b) {
		Polynomial result = new Polynomial();//결과값 객체생성
		int aPos = 0;
		int bPos = 0;

		while ((aPos < this.terms) && (bPos < b.terms)) {
			if (this.termArray[aPos].exp == b.termArray[bPos].exp) {
				float t = termArray[aPos].coef + b.termArray[bPos].coef;
				if (t != 0) {
					result.newTerm(t, termArray[aPos].exp);
				}
				aPos++;
				bPos++;
			} else if (this.termArray[aPos].exp < b.termArray[bPos].exp) {
				result.newTerm(b.termArray[bPos].coef, b.termArray[bPos].exp);
				bPos++;
			} else {
				result.newTerm(this.termArray[aPos].coef, this.termArray[aPos].exp);
				aPos++;
			}
		}

		for (; aPos < terms; aPos++) {
			result.newTerm(this.termArray[aPos].coef, this.termArray[aPos].exp);
		}

		for (; bPos < terms; bPos++) {
			result.newTerm(this.termArray[bPos].coef, this.termArray[bPos].exp);
		}
		return result;
	}

	// 구현 부분

	public Polynomial Mul(Polynomial b) {
		Polynomial result = null;// 연산의 결과를 반환할 객체 result 생성
		Polynomial c = null;
		for (int i = 0; i < terms; i++) {
			c = new Polynomial();
			for (int j = 0; j < b.terms; j++) {
				c.newTerm(termArray[i].coef * b.termArray[j].coef, termArray[i].exp + b.termArray[j].exp);
			}
			if (i == 0) {
				result = c;
			} else {
				result = c.add(result);
			}
		}
		return result; // 결과값을 저장한 result 반환
	}
}
