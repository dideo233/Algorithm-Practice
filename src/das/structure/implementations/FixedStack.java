package das.structure.implementations;


/**
 * 고정 크기 배열 기반 스택 자료구조
 * - 크기 고정 (size 제한 있음)
 * - top 값을 증감하는 것으로 구현
 *
 * 주요 메서드:
 * - push(item): 스택에 요소 추가 (++top)
 * - pop(): 최상단 요소 제거 및 반환 (top--)
 * - top(): 최상단 요소 조회 (top 위치의 값 반환)
 */
public class FixedStack {
    private Object[] items;
    private int top;

    public FixedStack(int size) {
        items = new Object[size];
        top = -1;
    }

    public boolean push(Object item) {
       if (top == items.length - 1) {
            return false;
       }
       items[++top] = item;
       return true;
    }

    public Object pop() {
        if (top == -1) {
            return null;
        }
        return items[top--];
    }

    public Object top(){
        if (top == -1) {
            return null;
        }
        return items[top];
    }

    public int size() {
        return top + 1;
    }
}
