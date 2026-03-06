import java.util.Arrays;

class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    int[] postfix = new int[nums.length];

    int n = nums.length;
    prefix[0] = 1;
    postfix[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
      postfix[n - i - 1] = postfix[n - i] * nums[n - i];
    }

    for (int i = 0; i < n; i++) {
      nums[i] = postfix[i] * prefix[i];
    }

    return nums;
  }

  public int[] productExceptSelfOptimal(int[] nums) {
    int n = nums.length;
    int pre = 1, post = 1;
    int[] ans = new int[n];

    for (int i = 0; i < n; i++) {
      ans[i] = pre;
      pre = pre * nums[i];
    }

    for (int i = n - 1; i >= 0; i--) {
      ans[i] = post * ans[i];
      post = post * nums[i];
    }

    return ans;
  }

  public static void main(String[] args) {
    ProductExceptSelf pes = new ProductExceptSelf();
    int[] arr = { 1, 2, 3, 4 };
    IO.println(Arrays.toString(pes.productExceptSelf(arr)));
  }
}
