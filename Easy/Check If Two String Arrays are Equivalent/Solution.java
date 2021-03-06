class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i,j,ii,jj;
        i = j = ii = jj = 0;
        while(i < word1.length && j < word2.length){
            if(word1[i].charAt(ii++) != word2[j].charAt(jj++)) return false;
            if(ii == word1[i].length()){
                 ii = 0;
                 i++;
            }
            if( jj == word2[j].length()){
                jj = 0; 
                j++;
            }
         }
        return i == word1.length && j == word2.length;
    }
}