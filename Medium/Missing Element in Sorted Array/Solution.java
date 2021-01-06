class Solution {
    public int missingElement(int[] nums, int k) {
        int ii = 0;
        for (int i = 1; i < nums.length; ++i){
            if(nums[i] - nums[i-1] != 1) {
                int diff = 1;
                while(true){
                    if (k == diff)
                        return nums[i-1] + diff;
                    if(nums[i] - nums[i-1] - diff == 1) {
                        k -= diff;
                        break;
                    }
                    diff++;
                }
            }
        }
        return nums[nums.length-1] + k;
    }
}



// /Same logic, but little more optimized:
class Solution {
    public int missingElement(int[] nums, int k) {
        int ii = 0;
        for (int i = 1; i < nums.length; ++i){
            int diff = nums[i] - nums[i-1] - 1;
            if(diff >= k)
                return nums[i-1] + k;
            k -= diff;
        }
        return nums[nums.length-1] + k;
    }
}