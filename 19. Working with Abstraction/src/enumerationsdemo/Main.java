package enumerationsdemo;

public class Main {

    public static void main(String[] args) {
        Weekday day = Weekday.MONDAY;

        System.out.println(day);

        Weekday[] values = Weekday.values();

        String str = "Monday";
        Weekday weekday = Weekday.valueOf(str.toUpperCase());
    }
}

