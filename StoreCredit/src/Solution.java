import static java.util.Arrays.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	private String solveCase() throws IOException {
		final int T = nextInt();
		final int N = nextInt();
		final int[] a = new int[N];
		final int[] b = new int[N];
		for (int k = 0; k < N; k++) {
			a[k] = nextInt();
			b[k] = a[k];
		}
		sort(a);
		int i = 0, j = N -1;
		while (i != j) {
			final int sum = a[i] + a[j];
			if (sum < T) i++;
			else if (sum > T) j--;
			else break;
		}
		int m = 0;
		while (m < N && b[m] != a[i]) m++;
		b[m++] = -1;
		int n = 0;
		while (n < N && b[n] != a[j]) n++;
		b[n++] = -1;
		if (m < n) return m + " " + n;
		else return n + " " + m;
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