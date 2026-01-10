import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Declaring a PriorityQueue in java:
 *    Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
 *
 *
 *  A Comparator follows a standard "three-way" contract:
 *      Negative result (\(<0\)): Element a is "smaller" (higher priority in a min-heap) than b.
 *      Zero result (\(0\)): a and b have equal priority.
 *      Positive result (\(>0\)): Element a is "larger" (lower priority in a min-heap) than b.
 *
 *
 *  Important Caution: Overflow:
 *      While a - b is a common shorthand in competitive programming, it is not recommended for production code. 
 *
 *      Risk: If a is a very large positive number and b is a very large negative number,
 *            a - b can overflow the capacity of an integer,
 *            leading to an incorrect sign and wrong sorting.
 *
 *        Better Practice: Use the built-in Integer.compare(a, b) method, which handles edge cases safely:
 *        Min-Heap: (a, b) -> Integer.compare(a, b)
 *        Max-Heap: (a, b) -> Integer.compare(b, a) 
 */

class TopKFrequent {
  public int[] topKFrequent(int[] nums, int k) {
    if (k == nums.length)
      return nums;

    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    Queue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compress(a, b));

    for (int n : map.keySet()) {
      heap.add(n);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = heap.poll();
    }

    return ans;
  }
}
