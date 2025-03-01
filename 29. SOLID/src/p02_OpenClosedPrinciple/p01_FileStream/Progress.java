package p02_OpenClosedPrinciple.p01_FileStream;

public class Progress {
    private final Sendable sendable;
    private int send;

    public Progress(Sendable sendable) {
        this.sendable = sendable;
    }

    public void process() {
        // logic
    }

    public int getCurrentPercent() {
        return send * 100 / sendable.getLength();
    }
}
