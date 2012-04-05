import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	class Employee implements Comparable<Employee> {
		final int town;
		final int seat;
		Employee(final int t, final int s) {
			town = t;
			seat = s;
		}

		@Override
		public int compareTo(final Employee other) {
			if (this.town != other.town) return (this.town - other.town);
			return (other.seat - this.seat);
		}

		@Override
		public String toString() {
			return town + "," + seat;
		}
	}

	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	private String solveCase() throws IOException {
		final int N = nextInt();
		final int T = nextInt();
		final int E = nextInt();

		final List<Employee> es = new ArrayList<Employee>();
		final int s[] = new int[N];
		for (int i = 0; i < E; i++) {
			final int H = nextInt();
			final int P = nextInt();
			es.add(new Employee(H, P));
			if (H != T) s[H-1]++;
		}
		Collections.sort(es);

		final int c[] = new int[N];
		for (final Employee e : es) {
			if (e.town == T) continue;
			final int i = e.town - 1;
			if (s[i] > 0) {
				s[i] -= e.seat;
				c[i]++;
			}
		}

		String res = "";
		for (int i = 0; i < N; i++) {
			if (s[i] <= 0) res += " " + c[i];
			else return "IMPOSSIBLE";
		}

		return res.substring(1);
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