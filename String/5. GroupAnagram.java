import java.util.*;

//
// @author Sheikh Robin
//
/*
 * When you assign a unique prime to each of the 26 letters (e.g., a=2, b=3,
 * c=5...), the product of those primes for any word creates a
 * "mathematical fingerprint".
 * Unique Composition: If two words are anagrams (e.g., "eat" and "tea"), they
 * have the exact same count of the same letters.
 * Therefore, their prime products (e.g., \(2\times 3\times 5=30\)) will always
 * be identical.
 * No "Accidental" Matches: Because primes cannot be formed by multiplying other
 * primes, it is mathematically impossible for a different combination of
 * letters to produce the same product.
 *
 * Example: To get a product of 30, you must have exactly one 2, one 3, and one
 * 5.
 * You cannot substitute two 2s to get a 4 because 4 is not in your prime list;
 * you can only use the 26 primes you assigned.
 *
 *
 *
 * The Real "Collision" Risk: Overflow
 * While the math says collisions are impossible, computer memory is limited.
 *
 * The Overflow Problem: Prime products grow extremely fast. For example, a word
 * with just 10 letters can easily exceed the capacity of a 64-bit integer
 * (long).
 * Collisions via Overflow: When a number exceeds its bit limit, it
 * "wraps around" (overflows). At this point, two different large products could
 * result in the same overflowed value, causing a hash collision.
 * 
 * The Better Alternatives
 * 
 * Frequency Array Key: Create a string key based on character counts (e.g.,
 * "1#0#2#..." for 1 'a', 0 'b', 2 'c'). This is \(O(N)\) and has zero collision
 * risk because the string uniquely represents the count of every
 * letter.BigInteger (Java): If you absolutely must use prime products, use
 * java.math.BigInteger. It handles arbitrarily large numbers without overflow,
 * preserving the unique factorization property, though it is slower and
 * consumes more memory than a simple array key.
 */

class GroupAnagram {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0)
      return new ArrayList<>();

    Map<String, List<String>> res = new HashMap<>();

    for (String s : strs) {
      char[] keyArr = s.toCharArray();
      Arrays.sort(keyArr);
      String key = String.valueOf(keyArr);
      res.computeIfAbsent(key, _ -> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(res.values());
  }

  public List<List<String>> groupAnagramsBetter(String[] strs) {
    if (strs.length == 0)
      return new ArrayList<>();

    Map<String, List<String>> res = new HashMap<>();
    int[] count = new int[26];

    for (String s : strs) {

      Arrays.fill(count, 0);

      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }

      StringBuilder sb = new StringBuilder("");

      for (int i : count) {
        sb.append('#').append(i);
      }

      res.computeIfAbsent(sb.toString(), _ -> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(res.values());
  }

  public static void main(String[] args) {
    GroupAnagram ga = new GroupAnagram();
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    IO.println(ga.groupAnagramsBetter(strs));
  }

}
