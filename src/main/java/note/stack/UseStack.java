package note.stack;

import java.util.Stack;

public class UseStack {

    public static void main(String[] args) {
        //deque 사용하는게 나음
        Stack<Integer> stack = new Stack<>();

        stack.push(1);     // stack에 1 추가
        stack.push(2);     // stack에 2 추가

        stack.pop();       // stack에 맨 위의 값 제거
        stack.clear();     // stack의 전체 값 제거 (초기화)

        stack.push(2);     // stack에 2 추가
        stack.push(4);     // stack에 4 추가
        stack.push(5);     // stack에 5 추가
        stack.peek();     // stack의 가장 상단의 값 출력 -> 5

        stack.contains(5); // stack에 5가 있는지 확인 -> false
        stack.size();      // stack의 크기 출력 : 2
        stack.empty();     // stack이 비어있는지 확인 (비어있다면 true)
    }
}
