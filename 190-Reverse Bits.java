class Solution {

    // Time = O(1);
    public int reverseBits(int n) {
        int m = 0;
        for (int i = 0; i < 32; i++) {
            m <<= 1;
            m = m | (n & 1);
            n >>= 1;
        }
        return m;
    }

    // Binary Search Method. Time = O(1);
    public int reverseBitsI(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}