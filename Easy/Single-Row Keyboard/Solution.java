class Solution {
    public int calculateTime(String keyboard, String word) {
        int distance = keyboard.indexOf(word.charAt(0));
        int previousPosition = distance;
        char[] letters = word.toCharArray();
        for(int i = 1; i < letters.length; ++i) {
            int currentLetterPosition = keyboard.indexOf(letters[i]);
            distance += Math.abs(previousPosition - currentLetterPosition);
            previousPosition = currentLetterPosition;
        }
        return distance;
    }
}