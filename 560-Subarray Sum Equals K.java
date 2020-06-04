class Solution {

    // use prefix to save space
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if ((prefix[j] - prefix[i]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}