public class LongestSubstringWithoutRepeatingCharacter {

    /**
     * @return the longest length of a substring with non-repeating characters.
     * 
     * A substring a defined as the characters in between two indices i and j (s[i:j]).
     * We can iterate over all such substrings by growing some window to its maximum size, until
     * we have a duplicate character.
     * After we have seen a duplicate character, we can shrink the window again.
     */
    public int longestLength(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        var chars = new HashSet<Character>();
        while (right < s.length()) {
            while (chars.contains(s.charAt(right))) {
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(s.charAt(right));
            maxLen = Math.max(maxLen, chars.size());
            right++;
        }
        return maxLen;
    }
}
