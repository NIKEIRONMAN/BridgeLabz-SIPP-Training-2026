import java.util.*;

public class Scenario2_BFSShortestPath {

    public static List<Integer> bfs(Map<Integer, List<Integer>> graph, int src, int dest) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.offer(src);
        visited.add(src);
        parent.put(src, null);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == dest)
                break;

            for (int next : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, node);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(dest))
            return Collections.emptyList();

        LinkedList<Integer> path = new LinkedList<>();

        for (Integer cur = dest; cur != null; cur = parent.get(cur))
            path.addFirst(cur);

        return path;
    }
}
