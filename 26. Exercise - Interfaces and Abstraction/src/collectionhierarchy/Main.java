package collectionhierarchy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" ")).toList();
        int removeCount = Integer.parseInt(scanner.nextLine());

        Addable addCollection = new AddCollection();
        AddRemovable addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        addElements(addCollection, elements);
        addElements(addRemoveCollection, elements);
        addElements(myList, elements);

        removeElements(addRemoveCollection, removeCount);
        removeElements(myList, removeCount);
    }

    private static void addElements(Addable collection, List<String> elements) {
        elements.forEach(e -> System.out.print(collection.add(e) + " "));
        System.out.println();
    }

    private static void removeElements(AddRemovable collection, int removeCount) {
        for (int i = 0; i < removeCount; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
