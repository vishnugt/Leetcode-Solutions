class MutableInteger {
    int value;
    public MutableInteger(){
        this.value = 0;
    }
    public void increment(){
        this.value++;
    }
}

class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, MutableInteger> charVsMap = new HashMap<>();
        for(char c : s.toCharArray()){
            MutableInteger mutInt = charVsMap.get(c);
            if( mutInt == null) {
                mutInt = new MutableInteger();
                charVsMap.put(c, mutInt);
            }
            mutInt.increment();
        }
        
        int oddCount = 0;
        for(MutableInteger count : charVsMap.values()) {
            if(count.value %2!=0) oddCount++;
        }
        
        return oddCount < 2;
    }
}