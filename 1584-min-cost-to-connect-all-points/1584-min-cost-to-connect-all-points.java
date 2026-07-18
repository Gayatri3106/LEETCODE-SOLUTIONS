class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> allEdges = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                allEdges.add(new Edge(i, j, dist));
            }
        }
        Collections.sort(allEdges, (a, b) -> a.w - b.w);
        UFDS uf = new UFDS(n);
        int cost = 0;
        int edgesUsed = 0;
        for (Edge e : allEdges) {
            if (uf.union(e.u, e.v)) {
                cost += e.w;
                edgesUsed++;
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }
        return cost;
    }
}


class Edge{
    int u,v,w;
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
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

















