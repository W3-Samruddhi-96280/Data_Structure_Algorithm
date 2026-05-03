package Day_09;



import java.util.Arrays;

public class KruskalAlgorithm {
	static class Edge implements Comparable<Edge> {
		private int src;
		private int dest;
		private int weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
	}

	private int find(int[] parent, int v) {
		if(parent[v] == v)
			return v;
		parent[v] = find(parent, parent[v]);
		return parent[v];
	}

	private void union(int[] parent, int[] rank, int x, int y) {
		int px = find(parent, x);
		int py = find(parent, y);

		if(rank[px] < rank[py])
			parent[px] = py;
		else if(rank[px] > rank[py])
			parent[py] = px;
		else {
			parent[py] = px;
			rank[px]++;
		}
	}

	public void mst(int vertices, Edge[] edges) {
		Arrays.sort(edges);

		int[] parent = new int[vertices];
		int[] rank = new int[vertices];

		for(int i = 0; i < vertices; i++)
			parent[i] = i;

		int total = 0;
		int count = 0;

		System.out.println("Kruskal MST");

		for(Edge edge : edges) {
			int x = find(parent, edge.src);
			int y = find(parent, edge.dest);

			if(x != y) {
				System.out.println(edge.src + " - " + edge.dest + " = " + edge.weight);
				total += edge.weight;
				union(parent, rank, x, y);
				count++;

				if(count == vertices - 1)
					break;
			}
		}

		System.out.println("Total Weight : " + total);
	}
}
