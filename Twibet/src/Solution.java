import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	private void dfs(final Integer start, final Map<Integer, Set<Integer>> white, final Set<Integer> grey, final Set<Integer> black) {
		if (grey.contains(start)) return;
		grey.add(start);
		if (white.containsKey(start)) {
			for (final Integer end : white.get(start)) {
				dfs(end, white, grey, black);
			}
		}
		black.add(start);
	}

	private String solveCase() throws IOException {
		final int N = nextInt();
		final Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < N; i++) {
			final int F = nextInt();
			if (!graph.containsKey(F)) graph.put(F, new HashSet<Integer>());
			graph.get(F).add(i + 1);
		}
		final StringBuilder res = new StringBuilder();
		for (int i = 0; i < N; i++) {
			final Set<Integer> visited = new HashSet<Integer>();
			final Set<Integer> finished = new HashSet<Integer>();
			dfs(i + 1, graph, visited, finished);
			res.append(finished.size() + "\n");
		}
		return res.toString();
	}

	private void solve() throws IOException {
		final int testNumber = nextInt();
		for (int test = 0; test < testNumber; test++) {
			final String result = "Case #" + (test + 1) + ":\n" + solveCase();
			pw.print(result);
			System.out.print(result);
		}
	}

	private BufferedReader br;
	private PrintWriter pw;
	private StringTokenizer st;

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	String nextLine() throws IOException {
		return br.readLine();
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	public static void main(final String[] args) throws IOException {
		new Solution().run();
	}

	private void run() throws IOException {
		br = new BufferedReader(new FileReader("input.txt"));
		pw = new PrintWriter("output.txt");
		solve();
		br.close();
		pw.flush();
		pw.close();
	}
}