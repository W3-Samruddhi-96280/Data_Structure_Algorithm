package Day_09;



public class Main {
	public static void main(String[] args) {
		int[][] graph = {
			{0, 2, 0, 6, 0},
			{2, 0, 3, 8, 5},
			{0, 3, 0, 0, 7},
			{6, 8, 0, 0, 9},
			{0, 5, 7, 9, 0}
		};

		DijkstraShortestPath dsp = new DijkstraShortestPath();
		dsp.shortestPath(graph, 0);

		PrimAlgorithm prim = new PrimAlgorithm();
		prim.mst(graph);

		KruskalAlgorithm.Edge[] edges = {
			new KruskalAlgorithm.Edge(0, 1, 2),
			new KruskalAlgorithm.Edge(0, 3, 6),
			new KruskalAlgorithm.Edge(1, 2, 3),
			new KruskalAlgorithm.Edge(1, 3, 8),
			new KruskalAlgorithm.Edge(1, 4, 5),
			new KruskalAlgorithm.Edge(2, 4, 7),
			new KruskalAlgorithm.Edge(3, 4, 9)
		};

		KruskalAlgorithm kruskal = new KruskalAlgorithm();
		kruskal.mst(5, edges);

		FibonacciCompare fib = new FibonacciCompare();
		System.out.println("Fibonacci Brute Force : " + fib.bruteForce(10));
		System.out.println("Fibonacci Dynamic Programming : " + fib.dynamicProgramming(10));
	}
}
