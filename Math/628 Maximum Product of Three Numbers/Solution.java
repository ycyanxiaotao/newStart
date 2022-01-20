class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxOne = Integer.MIN_VALUE, maxTwo = Integer.MIN_VALUE, maxThree = Integer.MIN_VALUE, minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxOne) {
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = nums[i];
                
            } else if (nums[i] > maxTwo) {
                maxThree = maxTwo;
                maxTwo = nums[i];
            } else if (nums[i] > maxThree) {
                maxThree = nums[i];
            }
            
            if (nums[i] < minOne) {
                minTwo = minOne;
                minOne = nums[i];
            } else if (nums[i] < minTwo) {
                minTwo = nums[i];
            }
            
        }
        return Math.max(maxOne * maxTwo * maxThree, minOne * minTwo * maxOne);
    }
}











// class Solution {
//     public int maximumProduct(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         Arrays.sort(nums);
//         int n = nums.length;
//         return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
//     }
// }