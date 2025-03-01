package reflectiontask;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        Class<reflectionTask.Reflection> clazz = reflectionTask.Reflection.class;
//
//        Class<?> demoClazz = Class.forName("reflectionTask.Reflection");
//
//        Constructor<?>[] constructors = clazz.getConstructors();
//
//        Method[] methods = clazz.getMethods();
//
//        Field[] fields1 = clazz.getFields();
//
//        Field[] fields2 = clazz.getDeclaredFields();
//
//        for (Field field : fields2) {
//            System.out.println(field.getType());
//        }

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Arrays.stream(clazz.getInterfaces()).forEach(System.out::println);

        Constructor<Reflection> cons = clazz.getConstructor();
        Reflection reflection = cons.newInstance();
        System.out.println(reflection);
    }
}
