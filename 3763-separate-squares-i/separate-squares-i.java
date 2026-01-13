class Solution {

    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0;

        // Step 1: find search range and total area
        for (int[] sq : squares) {
            double bottom = sq[1];
            double side = sq[2];

            totalArea += side * side;

            low = Math.min(low, bottom);
            high = Math.max(high, bottom + side);
        }

        double answer = 0;

        // Step 2: binary search on Y
        while (high - low > 1e-5) {

            double midY = low + (high - low) / 2;
            answer = midY;

            if (isBottomAreaMore(squares, midY, totalArea)) {
                // bottom area too big → go DOWN
                high = midY;
            } else {
                // bottom area too small → go UP
                low = midY;
            }
        }

        return answer;
    }

    // Step 3: check if area BELOW y is >= half of total area
    private boolean isBottomAreaMore(int[][] squares, double y, double totalArea) {

        double bottomArea = 0;

        for (int[] sq : squares) {
            double bottom = sq[1];
            double side = sq[2];
            double top = bottom + side;

            if (y <= bottom) {
                // square completely above the line
                continue;
            } 
            else if (y >= top) {
                // square completely below the line
                bottomArea += side * side;
            } 
            else {
                // line cuts the square
                bottomArea += (y - bottom) * side;
            }
        }

        return bottomArea >= totalArea / 2.0;
    }
}
