public class ParenthesesValidator {
    
    private final static Set<Character> openingBrackets = Set.of('(', '{', '[');
    private final static Map<Character, Character> openOf = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        for (var bracket : s.toCharArray()) {
            if (openingBrackets.contains(bracket)) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty() || stack.peek() != openOf.get(bracket)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}