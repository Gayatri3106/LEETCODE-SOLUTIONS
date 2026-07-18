class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UFDS ds = new UFDS(n);
        for (int[] x : edges) {
            int u = x[0];
            int v = x[1];
            if (!ds.union(u,v)) {
                return x;
            }
        }
        return new int[0];
    }
}

class UFDS{
    int n;
    int[] parent;
    public UFDS (int n){
        this.n = n;
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    boolean union(int x, int y){
        int leaderX = find(x);
        int leaderY = find(y);
        if(leaderX == leaderY) return false;
        parent[leaderY] = leaderX;
        return true;
    }
}








