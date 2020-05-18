package ru.ifmo.collections;


import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private final HashSet<Integer> nonUnique = new HashSet<>();
    private final ArrayDeque<Integer> unique = new ArrayDeque<>(0);

    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            if (!nonUnique.contains(number)) {
                if (unique.contains(number)) {
                    unique.remove(number);
                    nonUnique.add(number);
                } else {
                    unique.add(number);
                }
            }
        }
    }

    public int showFirstUnique() {
        if (unique.peek() == null) {
            return -1;
        } else {
            return unique.peek();
        }
    }

    public void add(int value) {
        if (!nonUnique.contains(value)) {
            if (unique.contains(value)) {
                unique.remove(value);
                nonUnique.add(value);
            } else {
                unique.add(value);
            }
        }
    }

}
