class Solution {
    StringBuilder path;
    ArrayList<String> allPaths;
    int n;
    public List<String> generateParenthesis(int n) {
        path = new StringBuilder();
        allPaths = new ArrayList<>();
        this.n = n;
        helper(0,0);
        return allPaths;
    }
    public void helper(int oc, int cc){
        if(path.length() == 2*n){
            allPaths.add(path.toString());
            return;
        }
         if (oc < n) {
            path.append('(');
            helper(oc + 1, cc);
            path.setLength(path.length() - 1);
        }
        if(cc < oc){
            path.append(')');
            helper(oc, cc+1);
            path.setLength(path.length()-1);
        }
    }
}