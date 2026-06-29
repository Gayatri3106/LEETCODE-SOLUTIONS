class Solution {
    public boolean isPalindrome(int x) {
        boolean ans = false;
       if(x<0){
        ans = false;
       }
       int temp=x, num=0, rev=0;
       while(x>0){
        num = x%10;
        rev = (rev*10)+num;
        x = x/10;
       }
        if(rev == temp){
            ans = true;
        }
        return ans;
    }
}