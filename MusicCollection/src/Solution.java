import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	public class Order implements Comparator<String> {
		@Override
		public int compare(final String s1, final String s2) {
			final int len1 = s1.length();
			final int len2 = s2.length();
			if(len1 != len2) return len1 - len2;
			return s1.compareTo(s2);
		}
	}

	List<String> c = null;
	private boolean contains(final String t, final int index) {
		for (int i = 0; i < c.size(); i++) {
			if (i != index)
				if (c.get(i).contains(t)) return true;
		}
		return false;
	}

	private String solveCase() throws IOException {
		final int N = nextInt();

		c = new ArrayList<String>();
		final List<Set<String>> ls = new ArrayList<Set<String>>();
		for (int i = 0; i < N; i++) {
			final String name = nextLine().toUpperCase();
			c.add(name);
			final Set<String> s = new TreeSet<String>(new Order());
			for (int m = 0; m < name.length(); m++) {
				for (int n = m + 1; n < name.length() + 1; n++) {
					s.add(name.substring(m, n));
				}
			}
			ls.add(s);
		}
		if (N == 1) return "\"\"";
//		debug(c);
//		debug(ls);
		final StringBuilder res = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String r = null;
			final Set<String> s = ls.get(i);
			for (final String t : s) {
				if (!contains(t, i)) {
					r = t;
					break;
				}
			}
			if (r == null) res.append(":(\n");
			else res.append("\"" + r + "\"\n");
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