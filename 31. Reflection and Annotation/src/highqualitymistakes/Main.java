package highqualitymistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get") && !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " have to be public!"));
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set") && !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " have to be private!"));
    }
}
