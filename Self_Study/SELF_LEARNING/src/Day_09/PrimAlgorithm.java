package Day_09;


public class PrimAlgorithm {
	private int minKey(int[] key, boolean[] mst) {
		int min = Integer.MAX_VALUE;
		int index = -1;

		for(int i = 0; i < key.length; i++) {
			if(!mst[i] && key[i] < min) {
				min = key[i];
				index = i;
			}
		}
		return index;
	}

	public void mst(int[][] graph) {
		int n = graph.length;
		int[] parent = new int[n];
		int[] key = new int[n];
		boolean[] mst = new boolean[n];

		for(int i = 0; i < n; i++) {
			key[i] = Integer.MAX_VALUE;
			parent[i] = -1;
		}

		key[0] = 0;

		for(int count = 0; count < n - 1; count++) {
			int u = minKey(key, mst);
			mst[u] = true;

			for(int v = 0; v < n; v++) {
				if(graph[u][v] != 0 && !mst[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		int total = 0;
		System.out.println("Prim MST");
		for(int i = 1; i < n; i++) {
			System.out.println(parent[i] + " - " + i + " = " + graph[i][parent[i]]);
			total += graph[i][parent[i]];
		}
		System.out.println("Total Weight : " + total);
	}
}
