class Solution {
    public int sumSubarrayMins(int[] arr) {
         int n = arr.length;
        int mod = 1_000_000_007;

        int[] left = getNSL(arr, n);
        int[] right = getNSR(arr, n);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long l = i - left[i];
            long r = right[i] - i;

            ans = (ans + arr[i] * l * r) % mod;
        }

        return (int) ans;
    }

    // 🔹 Next Smaller to Left
    private int[] getNSL(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;  // no smaller on left
            } else {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

    // 🔹 Next Smaller to Right
    private int[] getNSR(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = n;  // no smaller on right
            } else {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }
}