package calculator;

public class InputInterpreter {
    private CalculationEngine engine;
    private MemorySaveOperation memorySaveOperation;
    private MemoryRecallOperation memoryRecallOperation;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memorySaveOperation = new MemorySaveOperation();
        this.memoryRecallOperation = new MemoryRecallOperation(memorySaveOperation);
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        return switch (operation) {
            case "*" -> new MultiplicationOperation();
            case "/" -> new DivisionOperation();
            case "ms" -> memorySaveOperation;
            case "mr" -> memoryRecallOperation;
            default -> null;
        };
    }
}
