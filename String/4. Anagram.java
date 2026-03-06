import java.util.*;

class Anagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;

    Map<Character, Integer> mp = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char cs = s.charAt(i);
      char ct = t.charAt(i);
      mp.put(cs, mp.getOrDefault(cs, 0) + 1);
      mp.put(ct, mp.getOrDefault(ct, 0) - 1);
    }

    for (int i : mp.values())
      if (i != 0)
        return false;

    return true;
  }
}
