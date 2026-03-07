import java.util.*;

class SlidingWindowMax {
  public int[] maxSlidingWindow(int[] nums, int k) {

    int n = nums.length;
    int[] ans = new int[n - k + 1];

    Deque<Integer> dq = new LinkedList<>();

    for (int i = 0; i < n; i++) {

      if (!dq.isEmpty() && dq.peek() <= i - k) {
        dq.poll();
      }

      while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        dq.pollLast();
      }

      dq.offer(i);

      if (i >= k - 1) {
        ans[i - k + 1] = nums[dq.peek()];
      }

    }

    return ans;
  }
}
