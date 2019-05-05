public class Solution {
    public int reverse(int x) {
        int flag;
        if (x < 0) {
            x = Math.abs(x);
            flag = -1;
        } else {
            flag = 1;
        }
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            res = res * 10 + digit;

        }
        return res * flag;
    }
}
