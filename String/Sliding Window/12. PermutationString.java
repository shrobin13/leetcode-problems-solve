class PermutationString {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;
    int[] s1Freq = new int[26];
    int[] s2Freq = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      s1Freq[s1.charAt(i) - 'a']++;
      s2Freq[s2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length() - s1.length(); i++) {
      if (isMatching(s1Freq, s2Freq)) {
        return true;
      }

      s2Freq[s2.charAt(i + s1.length()) - 'a']++;
      s2Freq[s2.charAt(i) - 'a']--;
    }

    return isMatching(s1Freq, s2Freq);
  }

  public static boolean isMatching(int[] s1Freq, int[] s2Freq) {
    for (int i = 0; i < 26; i++) {
      if (s1Freq[i] != s2Freq[i]) {
        return false;
      }
    }

    return true;
  }

  public boolean checkInclusionBetter(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;

    int[] count = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      count[s1.charAt(i) - 'a']++;
      count[s2.charAt(i) - 'a']--;
    }

    if (isAllZero(count))
      return true;

    for (int i = s1.length(); i < s2.length(); i++) {
      count[s2.charAt(i) - 'a']--;
      count[s2.charAt(i - s1.length()) - 'a']++;
      if (isAllZero(count))
        return true;
    }

    return false;

  }

  public static boolean isAllZero(int[] count) {
    for (int i : count) {
      if (i != 0)
        return false;
    }
    return true;
  }
}
