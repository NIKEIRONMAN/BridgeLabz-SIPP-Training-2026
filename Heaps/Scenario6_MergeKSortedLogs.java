import java.util.*;

class LogEntry {
    int timestamp;

    LogEntry(int timestamp) {
        this.timestamp = timestamp;
    }
}

public class Scenario6_MergeKSortedLogs {

    static List<LogEntry> merge(List<List<LogEntry>> sources) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> sources.get(a[0]).get(a[1]).timestamp
                        - sources.get(b[0]).get(b[1]).timestamp);

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            merged.add(sources.get(cur[0]).get(cur[1]));

            if (cur[1] + 1 < sources.get(cur[0]).size()) {
                minHeap.offer(new int[]{cur[0], cur[1] + 1});
            }
        }

        return merged;
    }
}
