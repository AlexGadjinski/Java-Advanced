package randomarraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    public T getRandomElement() {
        int index = new Random().nextInt(size());
        return remove(index);
    }
}
