class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] count = new int[102];
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        for(int i=1; i<count.length; i++){
            count[i] = count[i] + count[i-1];
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                nums[i]=0;
            }else{
                nums[i] = count[nums[i]-1];
            }
        }
        return nums;
    }
}