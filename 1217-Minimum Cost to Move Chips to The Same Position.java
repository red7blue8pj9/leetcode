
class MinimumCostToMoveChipsToSamePosition {

    // Math.
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int chip : position) {
            if (chip % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}