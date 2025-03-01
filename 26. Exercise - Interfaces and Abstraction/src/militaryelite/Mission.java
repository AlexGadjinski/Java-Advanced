package militaryelite;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    private void setState(String state) {
        switch (state) {
            case "inProgress" -> this.state = State.IN_PROGRESS;
            case "finished" -> this.state = State.FINISHED;
            default -> throw new IllegalArgumentException();
        }
    }

    public void completeMission() {
        state = State.FINISHED;
    }

    @Override
    public String toString() {
        return "Code Name: %s State: %s".formatted(codeName, state);
    }
}
