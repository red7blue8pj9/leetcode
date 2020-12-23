import java.util.*;

class SmallestRangeII {

    // Linear Scan. 
    public int smallestRangeII(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int ans = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int a = A[i];
            int b = A[i + 1];
            int high = Math.max(A[n - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

}