package militaryelite;

public enum State {
    IN_PROGRESS,
    FINISHED;

    @Override
    public String toString() {
        return switch (this) {
            case IN_PROGRESS -> "inProgress";
            case FINISHED -> "finished";
        };
    }
}
