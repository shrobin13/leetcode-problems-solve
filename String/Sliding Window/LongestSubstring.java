class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int[] count = new int[256];
    int left = 0, max = 0;

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i)]++;
      while (count[s.charAt(i)] > 1) {
        count[s.charAt(left++)]--;
      }
      max = Math.max(max, (i - left + 1));
    }

    return max;
  }
}
