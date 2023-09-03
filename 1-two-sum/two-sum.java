class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            hm.put(nums[i],i);
        }

        int[] result = new int[2];

        for(int i = 0; i < n; i++){
            //case1: current element and target are equal
            if(nums[i] == target && hm.containsKey(0)){
                result[0] = nums[i];
                result[1] = hm.get(0);
                break;
            }
            else if(hm.containsKey(target - nums[i])){
                //case2: elements are non repeatable
                if(hm.get(target - nums[i]) > i){
                    result[0] = i;
                    result[1] = hm.get(target - nums[i]);
                    break;
                }
            }
        }
        return result;
    }
}