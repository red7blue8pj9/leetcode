import java.util.ArrayList;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0)
            return res;

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> newrow = new ArrayList<>();
            List<Integer> prevrow = res.get(i - 1);
            newrow.add(1);
            for (int j = 1; j < i; j++) {
                newrow.add(prevrow.get(j - 1) + prevrow.get(j));
            }
            newrow.add(1);
            res.add(newrow);
        }
        return res;
    }
}