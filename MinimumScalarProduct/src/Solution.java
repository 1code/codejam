import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}


	private String solveCase() throws IOException {
		final int N = nextInt();
		final Integer[] a = new Integer[N];
		final Integer[] b = new Integer[N];
		for (int i = 0; i < N; i++) a[i] = nextInt();
		for (int i = 0; i < N; i++) b[i] = nextInt();
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		BigInteger res = BigInteger.valueOf(0);
		for (int i = 0; i < N; i++) {
			final BigInteger a1 = BigInteger.valueOf(a[i]);
			final BigInteger b1 = BigInteger.valueOf(b[i]);
			res = res.add(a1.multiply(b1));
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