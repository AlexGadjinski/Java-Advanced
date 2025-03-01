package calculator;

import java.util.ArrayDeque;

public class MemorySaveOperation implements Operation {
    private ArrayDeque<Integer> stack;
    private int result;
    private boolean resultIsAdded;
    public MemorySaveOperation() {
        this.stack = new ArrayDeque<>();
        resultIsAdded = false;
    }
    @Override
    public void addOperand(int number) {
        stack.push(number);
        result = number;
        resultIsAdded = true;
    }

    @Override
    public int getResult() {
        resultIsAdded = false;
        return result;
    }

    @Override
    public boolean isCompleted() {
        return resultIsAdded;
    }

    public int popResult() {
        result = stack.peek();
        return stack.pop();
    }
}
