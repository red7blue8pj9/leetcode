class ATOI {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;

        char sign = '+';
        int i = 0;
        if (str.charAt(i) == '-') {
            sign = '-';
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        double res = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

            res = res * 10 + (str.charAt(i) - '0');
            i++;

        }

        if (sign == '-')
            res = -res;

        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) res;
    }
}