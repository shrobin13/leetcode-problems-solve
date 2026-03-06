
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

class ContainsDuplicateII {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashSet<Integer> window = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (window.contains(nums[i])) {
        return true;
      }

      window.add(nums[i]);

      if (i >= k) {
        window.remove(nums[i - k]);
      }
    }
    return false;
  }

  public boolean containsNearbyDuplicateHashmap(int[] nums, int k) {
    Map<Integer, Integer> mp = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if ((mp.containsKey(nums[i])) && (i - mp.get(nums[i]) <= k))
        return true;
      mp.put(nums[i], i);
    }
    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicateII cd = new ContainsDuplicateII();
    int[] arr = { 2, 7, 11, 15, 11 };
    System.out.println(cd.containsNearbyDuplicate(arr, 3));
  }

}
