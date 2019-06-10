package lol;

public class LinkedList {
	LinkedNode first; // LinekedList의 첫 node
	LinkedNode last; // LinekedList의 마지막 node

	LinkedList() {
		first = null;
		last = null;
	}

	protected void addFirst(int val) {// STACK
		// null을 값으로 지정하고 , 이미 값있으면 밀어서 또추가.
		if (first == null) {
			first = new LinkedNode(val);// 빈 스택에 노드 생성하고 값넣음
			last = first;// 하나라서
		} else {
			// 새 노드 생성
			LinkedNode newStack = new LinkedNode(val);
			// 새 노드의 다음 노드-.next를 이전 값에 top 에서 연결
			newStack.next = first;// 주소값
			// 배열로 보면 이전first가 밀리면서 새로들어오는 요소가 first됨
			// 따라서 first가 새 노드랑 연결
			// ....
			// 새 값 삽입후 새 노드 부름
			first = newStack;
		}
	}

	protected void addLast(int val) {// QUEUE
		if (first == null) {
			first = new LinkedNode(val);
			last = first; // 맨처음이라 값 하나 =front이자 last
		} else {
			// 이미 노드에 값있고 다음 노드 이어서 만듦
			LinkedNode newQ = new LinkedNode(val);
			// first 고정
			// last 늘어남 처음 last가 다음 노드 만들고, 다음 노드 값이 last됨
			last.next = newQ; // 빈 노드 생성, 값 넣고 새로운 노드로 연결
			last = last.next; // 다음 노드가 현재위치로/주소..위치
		}
	}

	protected Boolean removeFirst() {
		if (first == null)
			return false;
		else {
			if (first == last) {// 1개 남을때

			} else {// 여러개일때
				first = first.next; // 다음꺼 호출해 빼내기
			}
		}
		return true;

	}

	protected Boolean removeLast() { // n번째 삭제 =n-1노드를 n+1연결
		//null 일때 / 1개일때 first=last /여러개일때
		if (first == null)
			return false;
		else {
			if (first == last)
				first = null;
			else {
				//현재위치에서=first 노드 하나 만듦=current
				//노드가 계속 다음 노드를 부르면서 last 인지 확인함. last 이면 멈춤
				//
				LinkedNode current;
				for (current = first; current.next != last; current = current.next)
					;
				//current.next == last / 다음노드가 마지막값을 찾으면
				current.next = null; // 커렌트 -last = 커렌트 다음이 last 이므로 null 지정해서 없애고
				last = current; //현재 커렌트 위치가 last가 됨.
			}
		}
		return true;
	}

	protected void printList() {
		LinkedNode current = first;
		while (current != null) { // current 노드가 null 아닐때 까지 실행
			System.out.println(current.val);
			current = current.next; // next 노드를 current에 덮어 씌움
		}
	}
}
