class Solution {
    public int countArrangement(int n) {
        int[] res = new int[1];
        boolean[] visited = new boolean[n + 1];
        backtrack(res, visited, n, n);
        return res[0];
    }
    
    private void backtrack(int[] res, boolean[] visited, int n, int i) {
        if (i == 0) {
            res[0]++;
        } else {
            for (int num = n; num > 0; num--) {
                if (!visited[num] && (num % i == 0 || i % num == 0)) {
                    visited[num] = true;
                    backtrack(res, visited, n, i - 1);
                    visited[num] = false;
                }
            }   
        }
    }
}