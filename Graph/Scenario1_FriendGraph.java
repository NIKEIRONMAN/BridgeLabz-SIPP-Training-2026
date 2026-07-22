import java.util.*;

public class Scenario1_FriendGraph {

    private Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    public static void main(String[] args) {
        Scenario1_FriendGraph g = new Scenario1_FriendGraph();

        g.addFriendship(1, 2);
        g.addFriendship(2, 3);

        System.out.println(g.isFriend(1, 2));
        System.out.println(g.isFriend(1, 3));
    }
}
