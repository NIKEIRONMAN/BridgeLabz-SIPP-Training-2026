import java.util.*;

public class Scenario3 {

    public static List<List<String>> permutations(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, used, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(String[] arr, boolean[] used, List<String> current, List<List<String>> result) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(arr[i]);
            backtrack(arr, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}