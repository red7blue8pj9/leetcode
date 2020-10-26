import java.util.*;

class ValidSquare {

    // Sorting.
    public boolean validSquareI(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = { p1, p2, p3, p4 };
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2])
                && dist(p[3], p[2]) == dist(p[2], p[0]) && dist(p[0], p[3]) == dist(p[1], p[2]);
    }

    private double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    // If.
    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return dist(p1, p2) > 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4)
                && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
    }
}