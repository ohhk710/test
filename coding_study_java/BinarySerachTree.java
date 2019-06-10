
package binary_serach_tree;
import java.util.*;

public class BinarySerachTree {
	private Node root;

	public BinarySerachTree() {
		root = null;// 루트 노드 생성=값 비어잉음
	}

	public void add(int val) {// 새노드 삽입
		// (1)번 구현
		// 1.현재노드 비어있나?
		Node current = root; // 시작은 root부터이면=현재노드 우ㅣ치
		while (true) {

			if (root == null) {
				root = new Node(val); // 빈곳에 노드 생성= 호출

			} else { // 현재 노드에 이미 값존재.. 삽입할 노드 값과 비교시작
				if (current.val == val) {// 현노드값==삽입할노드값 : 중복안돰=종료
					return false;

				} else if (current.val < val) { // 찾는 값 더 크면 중심에서 오른쪽으로 현재노드이동
					current = current.right;
					if (current.right == null) { // 오른쪽노드가 비어있으면 노드 생성
						current = new Node(val);
					}

				} else if (current.val > val) {
					current = current.left;
					if (current.left == null) {
						current = new Node(val);
					}
				}
			}
		}
	}

	public Boolean search(int val) { // add전 탐색
		// (2)번 구현
		Node current = root;
		while (true) {
			if (current.val < val)
				current = current.right;
			else if (current.val > val)
				current = current.left;
			else // 같은 값
				current = false;// 종료
		}
	}

	public Boolean remove(int val) {
		// (4)번 구현
		// 빈노드 =종료
		// 현노드값==삭제할 노드값 : 현노드 가 삭제당함 : 현노드 서브트리 확인
		// 서브트리 없음 = 현노드 삭제
		// 왼쪽 서브트리=
		// 오른쪽 서브트리=
		// 양쪽=

	}

	private int getkMinVal() { //배열중 가장 왼쪽값
		// (3)번 구현
		Node current=root;
		while(true) {
		if(current==null)
			false;
		else if(current!=null) {
			current=current.left;
			if(current==null)
				false;
		}
		}
	}

	private int getkMaxVal() { // 가장 오른쪽값
		// (3)번 구현		
		Node current=root;
		while(true) {
		if(current==null)
			false;
		else if(current!=null) {
			current=current.right;
			if(current==null)
				false;
		}
		}
	}

	public void printTree() {
		System.out.print("[Print tree]");
		System.out.printf("\nMin value: %d", getkMinVal());
		System.out.printf("\nMax value: %d", getkMaxVal());
		System.out.print("\nIn-order : ");
		printInOrder(this.root);
		System.out.print("\nPre-order : ");
		printPreOrder(this.root);
		System.out.print("\nPost-order : ");
		printPostOrder(this.root);
		System.out.print("\nLevel-order : ");
		printLevelOrder(this.root);
	}

//여기서는 출력순서대로
	// 작은거-중간거-큰거
	private void printInOrder(Node current) {// 중위 : 왼-루트-오
		// (5)번 구현
		while (current != null) {
			System.out.println(current.val);
			printInOrder(current.left);
			printInOrder(current.right);
		}
	}

	private void printPreOrder(Node current) { // 전위 : 루트-왼-오 // 작은거-중간거-큰거
		// (5)번 구현
		while (current != null) {
			printInOrder(current.left);
			System.out.println(current.val);
			printInOrder(current.right);
		}
	}

	private void printPostOrder(Node current) {// 후위: 왼-오 -루트
		// (5)번 구현
		while (current != null) {
			printInOrder(current.right);
			System.out.println(current.val);
			printInOrder(current.left);
		}
	}

	private void printLevelOrder(Node current) { // 같은레벨 : 왼-오 -루트??
		// (5)번 구현 //보통 queue 로 한다
		Queue <Integer> Q=new Queue<Integer>();
		
	}
}
