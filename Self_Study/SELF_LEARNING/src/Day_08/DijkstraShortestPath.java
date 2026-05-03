package Day_08;


public class DijkstraShortestPath {
	private int minDistance(int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;

		for(int i = 0; i < dist.length; i++) {
			if(!visited[i] && dist[i] < min) {
				min = dist[i];
				index = i;
			}
		}
		return index;
	}

	public void shortestPath(int[][] graph, int src) {
		int n = graph.length;
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];

		for(int i = 0; i < n; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		for(int count = 0; count < n - 1; count++) {
			int u = minDistance(dist, visited);
			if(u == -1)
				break;

			visited[u] = true;

			for(int v = 0; v < n; v++) {
				if(!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}

			System.out.print("Step " + (count + 1) + " : ");
			for(int value : dist) {
				if(value == Integer.MAX_VALUE)
					System.out.print("INF ");
				else
					System.out.print(value + " ");
			}
			System.out.println();
		}

		System.out.println("Final Shortest Distances");
		for(int i = 0; i < n; i++)
			System.out.println(src + " to " + i + " = " + dist[i]);
	}
}
