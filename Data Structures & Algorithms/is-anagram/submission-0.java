class Solution {
    public boolean isAnagram(String s, String t) {

        // Step 1: If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create an array to count frequencies of 26 lowercase letters
        int[] count = new int[26];

        // Step 3: Increase count for characters in s
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Step 4: Decrease count for characters in t
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        // Step 5: Check if every count is zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

