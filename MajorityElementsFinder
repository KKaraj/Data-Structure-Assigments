class MajorityElementsFinder {
	//method to find all elements that appear more than ⌊n/3⌋ times in the array
    public List<Integer> majorityElement(int[] nums) {
        //create a map to store the frequency of each number in the array
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        // Count the occurrences of each number in the array
        for (int num : nums) {
            elementCountMap.put(num, elementCountMap.getOrDefault(num, 0) + 1);
        }

        //prepare list to store the result
        List<Integer> majorityElements = new ArrayList<>();
        int threshold = nums.length / 3;

        // iterate over the map entries to find the elements that appear more than n/3 times
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            if (entry.getValue() > threshold) {
                majorityElements.add(entry.getKey()); //add qualifying elements to result list
            }
        }

        return majorityElements;
    }
    public static void main(String[] args) {
    	MajorityElementsFinder solution = new MajorityElementsFinder();
        
        int[] nums = {3, 2, 3}; 
        
        System.out.println("Input: nums ");
        
        for (int num : nums) {
            System.out.print( num + " ");
        }
        
        System.out.println("\nOutput: ");
        System.out.println(solution.majorityElement(nums));
    }
} 
