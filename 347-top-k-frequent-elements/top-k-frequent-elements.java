 class Solution {
    public static int[] topKFrequent (int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        // Step 3: top k elements নাও
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] ans1 = topKFrequent(nums1, k1);
        System.out.print("Output: [");
        for (int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i]);
            if (i < ans1.length - 1) System.out.print(", ");
        }
        System.out.println("]"); // [1, 2]

        int[] nums2 = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k2 = 2;
        int[] ans2 = topKFrequent(nums2, k2);
        System.out.print("Output: [");
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i]);
            if (i < ans2.length - 1) System.out.print(", ");
        }
        System.out.println("]"); // [1, 2]
    }
}