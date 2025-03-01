package rawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    Car(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        tires = new ArrayList<>(List.of(tire1, tire2, tire3, tire4));
    }

    String getModel() {
        return model;
    }

    boolean isFragile() {
        if (cargo.getType().equals("fragile")) {
            for (Tire tire : tires) {
                if (tire.isWithLowPressure()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    boolean isFlammable() {
        return cargo.getType().equals("flamable") && engine.getPower() > 250;
    }
}
