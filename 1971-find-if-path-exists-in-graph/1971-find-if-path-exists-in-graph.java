class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //int n = edges.length;
        int ne = edges.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int u=0; u<n; u++){
            g.put(u,new ArrayList<>());
        }
        for(int i=0; i<ne; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(source);
        vis.add(source);
        while(!q.isEmpty()){
            int u = q.remove();

            if(u==destination) return true;

            for(int v : g.get(u)){
                if(!vis.contains(v)){
                    q.add(v);
                    vis.add(v);
                }
            }
        }
        return false;
    }
}