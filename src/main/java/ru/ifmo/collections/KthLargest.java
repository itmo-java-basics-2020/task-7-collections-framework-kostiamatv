package ru.ifmo.collections;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final ArrayList<Integer> kLargest;

    public KthLargest(int k, int[] numbers) {
        Arrays.sort(numbers);
        kLargest = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kLargest.add(numbers[numbers.length - i - 1]);
        }
    }

    public int add(int val) {
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < kLargest.size(); i++) {
            if (kLargest.get(i) < val) {
                int t = kLargest.get(i);
                kLargest.set(i, prev);
                prev = t;
            } else {
                prev = kLargest.get(i);
            }
        }
        return kLargest.get(kLargest.size() - 1);
    }
}
