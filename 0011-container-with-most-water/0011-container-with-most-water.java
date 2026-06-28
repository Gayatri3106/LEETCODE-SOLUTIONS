class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0, r= n-1, res=0;
        while(l<r){
            int minHt = Math.min(height[l],height[r]);
            int width = r - l;
            int vol = minHt * width;
            res = Math.max(res,vol);
            if(height[l]<height[r]){
                l++;
            } else{
                r--;
            }
        }
        return res;
    }
}