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
		final String an = next();
		final String sl = next();
		final String tl = next();
		final int sl_len = sl.length();
		long mul = 1;
		long sum = 0;
		for (int i = an.length() -1 ; i >= 0; i--) {
			sum += sl.indexOf(an.charAt(i)) * mul;
			mul *= sl_len;
		}
//		debug(sum);

		final int tl_len = tl.length();
		mul = 1;
		while (mul < sum) {
			mul *= tl_len;
		}
//		debug(mul);
		String res = "";
		while (mul > 0) {
			final int i = (int) (sum / mul);
//			debug(i);
			res += tl.charAt(i);
			sum = sum % mul;
			mul /= tl_len;
		}
		int i = 0;
		while (i < res.length() && res.charAt(i) == tl.charAt(0)) {
			i++;
		}
		return res.substring(i);
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