import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSeq {
  public int longestConsecutive(int[] nums) {
    if (nums.length == 0)
      return 0;

    Set<Integer> numSet = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      numSet.add(nums[i]);
    }

    int longestSeq = 0;
    for (int num : numSet) {
      if (numSet.contains(num - 1))
        continue;

      int currNum = num;
      int currSeq = 1;
      while (numSet.contains(currNum + 1)) {
        currNum++;
        currSeq++;
      }

      longestSeq = Math.max(currSeq, longestSeq);
    }

    return longestSeq;

  }
}
