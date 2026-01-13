import java.util.HashMap;
import java.util.Map;

class RomanToInt {
  public int romanToInt(String s) {
    Map<Character, Integer> mp = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
    int res = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      if (i + 1 < s.length() && mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
        res = res - mp.get(s.charAt(i));
      } else {
        res = res + mp.get(s.charAt(i));
      }
    }

    return res;
  }
}
