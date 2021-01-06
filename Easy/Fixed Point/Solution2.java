class Solution {
    public int fixedPoint(int[] A) {
        
        int start = 0;
        int end = A.length - 1;
        int ans = -1;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            if (mid == A[mid]) {
                ans = mid;
                end = mid - 1;
            }
            
            else if(mid < A[mid]) {
                end = mid - 1;
            }
            
            else if(mid > A[mid]) {
                start = mid + 1;
            }
            
        }
        
        return ans;
    }
}