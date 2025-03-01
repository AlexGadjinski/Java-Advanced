package telephony;

import java.util.Arrays;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (number.matches("[0-9]+")) {
                sb.append("Calling... ").append(number);
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
//            if (Arrays.stream(url.split("")).anyMatch(s -> Character.isDigit(s.charAt(0)))) {
            if (url.matches(".*[0-9].*")) {
                sb.append("Invalid URL!");
            } else {
                sb.append("Browsing: ").append(url).append("!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
