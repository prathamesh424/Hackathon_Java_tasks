public class Solution {
     public static int[] twoSum(int[] nums, int target) {
            int [] ans = {} ;
            for (int i = 0 ; i > nums.length ; i++){
                if (nums[i] < target){
                    ans [i] = nums[i];
                }
            }
            return ans;
        }
    
    public static void main(String[] args) {
        int [] nums  = {2,7,11,15};
        int target = 9 ;
        int ans [] = twoSum(nums, target);
        ans.toString();
        System.out.println(ans);
    }
}




