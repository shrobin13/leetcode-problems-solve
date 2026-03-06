import java.util.HashMap;
import java.util.Map;

class AlienDict {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> orderMap = new HashMap<>();

    // create char map
    for (int i = 0; i < order.length(); i++) {
      orderMap.put(order.charAt(i), i);
    }

    // compare every two consecutive words
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      // compare char by char
      for (int j = 0; j < Math.max(word1.length(), word2.length()); j++) {

        // Case 1: word1 ended but word2 continues → good (shorter first)
        if (j == word1.length()) {
          break; // word1 is prefix of word2 → correct order
        }

        // Case 2: word2 ended but word1 continues → bad (longer first)
        if (j == word2.length()) {
          return false;
        }

        if (word1.charAt(j) != word2.charAt(j)) {
          int first = orderMap.get(word1.charAt(j));
          int second = orderMap.get(word2.charAt(j));

          // if next word has smaller value than return false
          if (first > second) {
            return false;
          }

          // if next word has larger value then we can skip comparing
          else {
            break;
          }
        }

        // if chars are same continue
      }
    }

    // if no violation found
    return true;

  }
}
