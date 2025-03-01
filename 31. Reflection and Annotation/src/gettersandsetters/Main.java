package gettersandsetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .map(Main::toString)
                .forEach(System.out::println);
    }

    private static String toString(Method m) {
        if (m.getName().startsWith("get")) {
            return "%s will return class %s"
                    .formatted(m.getName(), m.getReturnType().getName());
        }
        return "%s and will set field of class %s"
                .formatted(m.getName(), m.getParameterTypes()[0].getName());
    }
}
