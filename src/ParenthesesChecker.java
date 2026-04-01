import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ParenthesesChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string of parentheses: ");
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("The parentheses are balanced and paired.");
        } else {
            System.out.println("The parentheses are NOT balanced or paired.");
        }
        scanner.close();
    }

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
    

    
    

