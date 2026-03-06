class LongestRepeatingCharRep {
  public int characterReplacement(String s, int k) {
    int[] count = new int[26];
    int left = 0, ans = 0, maxFreq = 0;

    for (int i = 0; i < s.length(); i++) {
      maxFreq = Math.max(maxFreq, ++count[s.charAt(i) - 'A']);
      if ((i - left + 1) - maxFreq > k) {
        maxFreq = Math.max(maxFreq, --count[s.charAt(left++) - 'A']);
      }
      ans = Math.max(ans, (i - left + 1));
    }
    return ans;
  }
}
