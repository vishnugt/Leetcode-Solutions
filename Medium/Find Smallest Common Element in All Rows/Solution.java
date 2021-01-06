class MutableInt{
    int value;
    public MutableInt(){
        value = 0;
    }
}

class Solution {
    public int smallestCommonElement(int[][] mat) {
        
        Map<Integer, MutableInt> map = new TreeMap();
        for(int[] row : mat){
            for(Integer number : row){
                MutableInt temp = map.get(number);
                if(temp == null) {
                    temp = new MutableInt();
                    map.put(number, temp);
                }
                temp.value++;
            }
        }
        
        for(Map.Entry<Integer, MutableInt> entry : map.entrySet()){
            if(entry.getValue().value == mat.length){
                return entry.getKey();
            }
        }
        
        return -1;
    }
}


//Better solution
public int smallestCommonElement(int[][] mat) {
    int n = mat.length, m = mat[0].length;
    int pos[] = new int[n];
    int currentMax = 0, count = 0;
    while (true) {
        for (int i = 0; i < n; ++i) {
            while (pos[i] < m && mat[i][pos[i]] < currentMax) {
                ++pos[i];
            }
            if (pos[i] >= m) {
                return -1;
            }
            if (mat[i][pos[i]] != currentMax) {
                count = 1;
                currentMax = mat[i][pos[i]];
            } else if (++count == n) {
                return currentMax;
            }
        }
    }
}