package Day_07;


import java.util.*;

class DFSExample {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // edges
        adj.get(0).add(1); adj.get(0).add(2);
        adj.get(1).add(0); adj.get(1).add(3); adj.get(1).add(4);
        adj.get(2).add(0);
        adj.get(3).add(1);
        adj.get(4).add(1);

        boolean[] visited = new boolean[V];
        dfs(0, adj, visited);
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int n : adj.get(node)) {
            if(!visited[n]) {
                dfs(n, adj, visited);
            }
        }
    }
}
