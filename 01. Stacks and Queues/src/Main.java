import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(33);
        stack.push(24);
        stack.push(92);

        stack.pop();
        stack.pop();
        stack.pop();
    }
}
