import java.util.*;

public class Scenario4_TopKLargest {

    static List<Integer> topK(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int x : arr) {
            if (minHeap.size() < k)
                minHeap.offer(x);
            else if (x > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(x);
            }
        }

        return new ArrayList<>(minHeap);
    }
}
