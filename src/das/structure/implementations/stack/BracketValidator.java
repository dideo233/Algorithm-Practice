package das.structure.implementations.stack;

/**
 * 스택 활용 예제 - 괄호 맞추기
 *
 * 검증 원리:
 * 1. '(' 만나면 push
 * 2. ')' 만나면 pop
 * 3. 순회 완료 후 스택이 비어있으면 검증 완료 (괄호 쌍 맞음)
 */
public class BracketValidator {

    public boolean isValid(String input) {
        DynamicStack<Character> stack = new DynamicStack<>();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // 스택이 비어있으면 ')' 만 남은 경우 → invalid
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }

        // 스택에 '('가 남아있으면 → invalid, 비어있으면 → valid
        return stack.size() == 0;
    }
}
