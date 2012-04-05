import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	class Pair{
		Set<Character> elems = new HashSet<Character>();
		Pair(final char first, final char second) {
			elems.add(first);
			elems.add(second);
		}
		@Override
		public int hashCode() {
			return elems.hashCode();
		}
		@Override
		public boolean equals(final Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Pair)) return false;
			final Pair other = (Pair) obj;
			return elems.equals(other.elems);
		}
	}

	private boolean isClear(final char c, final List<Character> res) {
		for (int j = res.size() - 1; j >= 0; j--) {
			final Pair p2 = new Pair(c, res.get(j));
			if (oppos.contains(p2)) {
				res.clear();
				return true;
			}
		}
		return false;
	}

	final Map<Pair, Character> combs = new HashMap<Pair, Character>();
	final Set<Pair> oppos = new HashSet<Pair>();

	private String solveCase() throws IOException {
		final int C = nextInt();
		combs.clear();
		for (int i = 0; i < C; i++) {
			final String str = next();
			combs.put(new Pair(str.charAt(0), str.charAt(1)), str.charAt(2));
		}
		final int D = nextInt();
		oppos.clear();
		for (int i = 0; i < D; i++) {
			final String str = next();
			oppos.add(new Pair(str.charAt(0), str.charAt(1)));
		}
		final int N = nextInt();
		final String str = next();
		final List<Character> res = new ArrayList<Character>();
		for (int i = 0; i < N; i++) {
			final char c = str.charAt(i);
			if (res.isEmpty()) {
				res.add(c);
			}
			else {
				final int size = res.size();
				final Pair p1 = new Pair(c, res.get(size-1));
				if (combs.containsKey(p1)) {
					res.remove(size - 1);
					res.add(combs.get(p1));
					continue;
				}
				else if (!isClear(c, res)) {
					res.add(c);
				}
			}
		}
		return res.toString();
	}

	private void solve() throws IOException {
		final int testNumber = nextInt();
		for (int test = 0; test < testNumber; test++) {
			final String result = "Case #" + (test + 1) + ": " + solveCase();
			pw.println(result);
			System.out.println(result);
		}
	}

	private BufferedReader br;
	private PrintWriter pw;
	private StringTokenizer st;

	int nextInt() throws IOException {
		return Integer.parseInt(next());
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