package Day_08;

import java.util.Map;

public class Main {
	public static void main(String[] args) {
		WordCounter wc = new WordCounter();
		Map<String, Integer> map = wc.countWords("java is easy and java is powerful");

		System.out.println("Word Count");
		for(String key : map.keySet())
			System.out.println(key + " = " + map.get(key));

		int[][] graph = {
			{0, 4, 0, 0, 0, 0},
			{4, 0, 8, 0, 0, 0},
			{0, 8, 0, 7, 0, 4},
			{0, 0, 7, 0, 9, 14},
			{0, 0, 0, 9, 0, 10},
			{0, 0, 4, 14, 10, 0}
		};

		DijkstraShortestPath dsp = new DijkstraShortestPath();
		dsp.shortestPath(graph, 0);
	}
}
