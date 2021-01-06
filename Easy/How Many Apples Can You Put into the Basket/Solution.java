class Solution {
    public int maxNumberOfApples(int[] arr) {
        int sum = 0;
        int count = 0;
        Arrays.sort(arr);
        for(int size : arr) {
            sum += size;
            if(sum > 5000) 
                break;
            count++;
        }    
        return count;
    }
}


//The same can also be done via Min-Heap (i.e. PriorityQueue in Java)
class Solution {
    public int maxNumberOfApples(int[] arr) {
        // note that build a heap only requires O(N)
        // more details: https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
        Queue<Integer> heap = new PriorityQueue<>();
        for (Integer weight: arr) {
            heap.add(weight);
        }
        int apples = 0, units = 0;

        while (!heap.isEmpty() && units + heap.peek() <= 5000) {
            units += heap.remove();
            apples += 1;
        }
        return apples;
    }
}