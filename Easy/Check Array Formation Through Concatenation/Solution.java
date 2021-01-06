class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for(int[] outer : pieces) {
            int firstElem = outer[0];
            int pos  = -1;
            for(int j = 0; j < arr.length; ++j)
                if (arr[j] == firstElem)
                    pos = j;
            if(pos == -1)
                return false;
            for(int i = 1; i < outer.length; ++i) {
                if(pos+1 >= arr.length || outer[i] != arr[++pos])
                    return false;
            }
        }
        return true;
    }
}