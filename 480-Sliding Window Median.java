import java.util.*;

class SlidingWindowMedian {

    // Two PriorityQueue. Time = O(N*log(K)); Space = O(N);
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) {
            return new double[0];
        }
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() <= minHeap.size()) {
                minHeap.add(nums[i]);
                maxHeap.add(minHeap.remove());
            } else {
                maxHeap.add(nums[i]);
                minHeap.add(maxHeap.remove());
            }

            if (maxHeap.size() + minHeap.size() == k) {
                double median;
                if (maxHeap.size() == minHeap.size()) {
                    median = (double) ((long) maxHeap.peek() + (long) minHeap.peek()) / 2;
                } else {
                    median = (double) maxHeap.peek();
                }

                int start = i - k + 1;
                result[start] = median;
                if (!maxHeap.remove(nums[start])) {
                    minHeap.remove(nums[start]);
                }
            }
        }
        return result;
    }

 
}