class Solution {
    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; ++i){
            int prev = i == 0 ? 0 : arr[i-1];
            int current = i == 0 ? arr[0] : arr[i];
            int diff = current - prev - 1;
            if(diff >= k)
                return prev + k;
            k -= diff;
        }
        return arr[arr.length-1] + k;
    }
}