class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        else if(nums.length==1){
            return nums[0];
        }
       
        int case1 = robLinear(nums,0,nums.length-2);
        int case2 = robLinear(nums,1,nums.length-1);
        
        return Math.max(case1 , case2);
    }
    
    private int robLinear(int[] nums , int start , int end){
            if(start==end){
                return nums[start];
            }

            int FirstHouse = nums[start];
            int SecondHouse = Math.max(nums[start],nums[start+1]);

            for(int i= start+2;i<=end;i++){
                int current = Math.max(SecondHouse , nums[i]+FirstHouse);
                FirstHouse = SecondHouse;
                SecondHouse = current;
            }
            return SecondHouse;
        }
}