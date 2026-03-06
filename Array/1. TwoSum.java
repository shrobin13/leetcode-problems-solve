import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> isTwoSum = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (isTwoSum.containsKey(complement))
        return new int[] { isTwoSum.get(complement), i };
      isTwoSum.put(nums[i], i);
    }
    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    TwoSum ts = new TwoSum();
    int[] arr = { 2, 7, 11, 15 };
    System.out.println(Arrays.toString(ts.twoSum(arr, 9)));
  }
}
