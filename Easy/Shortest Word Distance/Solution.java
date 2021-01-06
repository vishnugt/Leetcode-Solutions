class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Pos = -1;
        int word2Pos = -1;
        int minimumDistance  = words.length;
        
        for(int i = 0; i < words.length; ++i) {
            String word = words[i];
            
            if(word.equals(word1)) {
                word1Pos = i;
            }
            
            else if(word.equals(word2)) {
                word2Pos = i;
            }
            
            if(word1Pos != -1 && word2Pos != -1) {
                minimumDistance = Math.min(minimumDistance, Math.abs(word2Pos - word1Pos));
            }
        }
        return minimumDistance;
    }
}