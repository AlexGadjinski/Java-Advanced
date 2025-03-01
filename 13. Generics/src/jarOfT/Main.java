package jarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jarOfPickles = new Jar<>();

        jarOfPickles.add(13);
        jarOfPickles.add(20);

        System.out.println(jarOfPickles.remove());
    }
}
