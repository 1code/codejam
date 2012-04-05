import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	class Customer {
		List<Integer> unmalted = new ArrayList<Integer>();
		int malted = -1;
	}

	private String solveCase() throws IOException {
		final int N = nextInt();
		final int M = nextInt();
		final LinkedList<Customer> cs = new LinkedList<Customer>();
		for (int i = 0; i < M; i++) {
			final Customer c = new Customer();
			final int T = nextInt();
			for (int j = 0; j < T; j++) {
				final int type = nextInt();
				final int malted = nextInt();
				if (malted == 1) {
					c.malted = type - 1;
				}
				else {
					c.unmalted.add(type - 1);
				}
			}
			cs.add(c);
		}

		final int[] res = new int[N];
		final List<List<Customer>> ms = new ArrayList<List<Customer>>();
		for (int i =  0; i < N; i++) ms.add(new ArrayList<Customer>());
		while (!cs.isEmpty()) {
			final Customer c = cs.pollFirst();
			boolean found = false;
			for (final Integer i : c.unmalted) {
				if (res[i] == 0) {
					found = true;
					ms.get(i).add(c);
					break;
				}
			}
			if (!found) {
				if (c.malted == -1) return "IMPOSSIBLE";
				else {
					res[c.malted] = 1;
					for (final Customer s : ms.get(c.malted)) {
						cs.add(s);
					}
					ms.get(c.malted).clear();
				}
			}
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (res[i] == 1) sb.append("1 ");
			else sb.append("0 ");
		}
		return sb.toString().trim();
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