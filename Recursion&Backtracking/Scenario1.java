import java.util.*;

public class Scenario1 {

    public static List<List<String>> generateSubsets(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        backtrack(arr, 0, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(String[] arr, int index, List<String> current, List<List<String>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(arr[index]);
        backtrack(arr, index + 1, current, result);

        current.remove(current.size() - 1);
        backtrack(arr, index + 1, current, result);
    }
}