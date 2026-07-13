class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // Step 3: Put numbers into buckets based on frequency
        for (int num : freqMap.keySet()) {

            int freq = freqMap.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // Step 4: Collect top k frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {

                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
