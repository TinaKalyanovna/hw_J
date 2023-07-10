package HW_6;

import java.util.HashSet;
import java.util.Set;

public class task6_1 {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        cats.remove(cats.iterator().next());
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        // Реализовать метод createCats, множество (Set) котов и добавлением в него 3 кота.
        Set<Cat> cats = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            cats.add(new Cat());
        }
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // Реализовать метод printCats, вывод всех котов,
        // которые остались во множестве.
        for (Cat cat : cats){
            System.out.println(cat);
        }
    }

    public static class Cat {
    }
}
