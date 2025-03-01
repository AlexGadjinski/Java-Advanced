package calculator;

public class MemoryRecallOperation implements Operation {
    private MemorySaveOperation memorySaveOperation;

    public MemoryRecallOperation(MemorySaveOperation memorySaveOperation) {
        this.memorySaveOperation = memorySaveOperation;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return memorySaveOperation.popResult();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
