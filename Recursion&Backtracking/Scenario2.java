import java.util.*;

public class Scenario2 {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int[] nums, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) break;
            current.add(nums[i]);
            backtrack(nums, target - nums[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}