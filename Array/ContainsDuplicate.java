import java.util.HashSet;

class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> hash = new HashSet<>();
    for (int num : nums) {
      if (hash.contains(num))
        return true;
      hash.add(num);
    }
    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicate cd = new ContainsDuplicate();
    int[] arr = { 2, 7, 11, 15, 11 };
    System.out.println(cd.containsDuplicate(arr));
  }

}
