import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	private String solveCase() throws IOException {
		final int N = nextInt();
		int btime = 0;
		int otime = 0;
		int bat = 1;
		int oat = 1;
		for (int i = 0; i < N; i++) {
			final String R = next();
			final int P = nextInt();
//			debug(R, P);
			if (R.equals("B")) {
				btime = Math.max(btime + Math.abs(bat - P), otime) + 1;
				bat = P;
			}
			else {
				otime = Math.max(otime + Math.abs(oat - P), btime) + 1;
				oat = P;
			}
//			debug(bat, oat, btime, otime);
		}
		return String.valueOf(Math.max(btime, otime));
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