import java.util.*;

class Solution {

    // Max heap for k-1 smallest values
    private PriorityQueue<Integer> small =
            new PriorityQueue<>(Collections.reverseOrder());

    // Min heap for remaining values
    private PriorityQueue<Integer> large =
            new PriorityQueue<>();

    // Lazy deletion map
    private Map<Integer, Integer> delayed = new HashMap<>();

    private long sumSmall = 0;
    private int smallSize = 0;
    private int largeSize = 0;
    private int need;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        need = k - 1;

        long ans = Long.MAX_VALUE;

        // Initial window: indices [1 .. dist+1]
        for (int i = 1; i <= dist + 1 && i < n; i++) {
            add(nums[i]);
        }
        balance();

        if (smallSize == need) {
            ans = nums[0] + sumSmall;
        }

        // Slide window
        for (int i = dist + 2; i < n; i++) {
            int out = nums[i - dist - 1];
            remove(out);
            add(nums[i]);
            balance();

            if (smallSize == need) {
                ans = Math.min(ans, nums[0] + sumSmall);
            }
        }

        return ans;
    }

    private void add(int x) {
        if (!small.isEmpty() && x <= small.peek()) {
            small.offer(x);
            sumSmall += x;
            smallSize++;
        } else {
            large.offer(x);
            largeSize++;
        }
    }

    private void remove(int x) {
        delayed.put(x, delayed.getOrDefault(x, 0) + 1);

        if (!small.isEmpty() && x <= small.peek()) {
            smallSize--;
            sumSmall -= x;
        } else {
            largeSize--;
        }

        clean(small);
        clean(large);
    }

    private void balance() {
        // Move from small → large if extra
        while (smallSize > need) {
            int x = small.poll();
            clean(small);
            sumSmall -= x;
            smallSize--;
            large.offer(x);
            largeSize++;
        }

        // Move from large → small if short
        while (smallSize < need && !large.isEmpty()) {
            int x = large.poll();
            clean(large);
            sumSmall += x;
            largeSize--;
            small.offer(x);
            smallSize++;
        }
    }

    private void clean(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int x = heap.peek();
            if (delayed.containsKey(x)) {
                delayed.put(x, delayed.get(x) - 1);
                if (delayed.get(x) == 0) {
                    delayed.remove(x);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }
}

