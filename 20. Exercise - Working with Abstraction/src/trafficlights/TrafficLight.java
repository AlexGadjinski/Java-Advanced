package trafficlights;

public class TrafficLight {
    private Signal signal;

    public TrafficLight(String signal) {
        this.signal = Signal.valueOf(signal);
    }

    public void updateSignal() {
        signal = switch (signal) {
            case RED -> Signal.GREEN;
            case GREEN -> Signal.YELLOW;
            case YELLOW -> Signal.RED;
        };
    }

    public Signal getSignal() {
        return signal;
    }
}
