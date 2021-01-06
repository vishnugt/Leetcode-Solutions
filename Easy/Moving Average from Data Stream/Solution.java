class MovingAverage {

    Queue<Integer> data;
    double sum;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        data = new LinkedList();
        sum = 0d;
        this.size = size;
    }
    
    public double next(int val) {
        if(data.size() == size)
            sum -= data.remove();

        sum += val;
        data.add(val);
        
        return sum / data.size();
    }
}