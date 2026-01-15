import java.util.HashSet;

class FirstMissing {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // Step 1: Check if 1 is present. If not → answer is 1
    boolean hasOne = false;
    for (int num : nums) {
      if (num == 1) {
        hasOne = true;
        break;
      }
    }
    if (!hasOne)
      return 1;

    // Step 2: Replace all useless numbers with 1
    // Useless = < 1 or > n
    for (int i = 0; i < n; i++) {
      if (nums[i] < 1 || nums[i] > n) {
        nums[i] = 1;
      }
    }

    // Step 3: Mark presence using negative sign
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]); // absolute value = the number we want to mark

      if (num == n) {
        // Special case: mark n using nums[0]
        nums[0] = -Math.abs(nums[0]);
      } else {
        // Mark number 'num' by making nums[num] negative
        nums[num] = -Math.abs(nums[num]);
      }
    }

    // Step 4: Find first positive value (not marked → missing)
    for (int i = 1; i < n; i++) {
      if (nums[i] > 0) {
        return i; // number i is missing
      }
    }

    // Step 5: Check if n is missing (using nums[0])
    if (nums[0] > 0) {
      return n;
    }

    // Step 6: If everything 1 to n is present → answer is n+1
    return n + 1;
  }

  public int hfirstMissingPositive(int[] nums) {
    int n = nums.length;

    // HashSet for numbers in range [1, n]
    HashSet<Integer> present = new HashSet<>();

    // Add only relevant numbers (1 <= num <= n)
    for (int num : nums) {
      if (num >= 1 && num <= n) {
        present.add(num);
      }
    }

    // Check from 1 to n+1
    for (int i = 1; i <= n + 1; i++) {
      if (!present.contains(i)) {
        return i;
      }
    }

    // Theoretically unreachable
    return n + 1;
  }
}
