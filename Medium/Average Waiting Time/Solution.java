class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitedTimeAlone = 0;
        double extraTimeFromLastCook = 0;
        double totalCookTime = 0;
        for (int i = 0; i < customers.length; ++i) {
            totalCookTime += customers[i][1];
            if (i != 0) {
                if (extraTimeFromLastCook > customers[i][0]) {
                    double currentWaitedTime = extraTimeFromLastCook - customers[i][0];
                    waitedTimeAlone += currentWaitedTime;
                    customers[i][0] += currentWaitedTime;
                }
            }
            extraTimeFromLastCook = customers[i][0] + customers[i][1];
        }
        return (double) (totalCookTime + waitedTimeAlone) / customers.length;
    }
}