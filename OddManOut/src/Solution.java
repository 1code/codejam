import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	private String solveCase() throws IOException {
		final int n = nextInt();
		final int[] a = new int[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
			res ^= a[i];
		}
		return String.valueOf(res);
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