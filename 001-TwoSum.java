import java.util.*;

class TwoSum {
    // Brute Force
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Hashmap
    public int[] twoSumII(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int request = target - nums[i];
            if (numsMap.containsKey(request) && numsMap.get(request) != i) {
                return new int[] { numsMap.get(request), i };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
