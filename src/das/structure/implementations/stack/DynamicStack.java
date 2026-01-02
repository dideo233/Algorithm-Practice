package das.structure.implementations.stack;

import java.util.ArrayList;

/**
 * ArrayList 기반 스택 구현
 * - 크기 동적 확장 (size 제한 없음)
 * - ArrayList의 add/remove로 구현
 *
 * 주요 메서드:
 * - push(item): 스택에 요소 추가 (리스트 끝에 add)
 * - pop(): 최상단 요소 제거 및 반환 (마지막 인덱스 remove)
 * - top(): 최상단 요소 조회 (마지막 인덱스 get)
 */
public class DynamicStack<T> {

    private ArrayList<T> items;

    public DynamicStack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (items.isEmpty()) {
            return null;
        }

        return items.remove(items.size() - 1);
    }

    public T top() {
        if (items.isEmpty()) {
            return null;
        }
        return items.get(items.size() - 1);
    }

    public int size() {
        return items.size();
    }
}
