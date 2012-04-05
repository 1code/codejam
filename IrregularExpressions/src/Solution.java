import static java.util.Arrays.deepToString;
import static java.util.Arrays.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	private boolean isValid(final char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	private String solveCase() throws IOException {
		final String line = nextLine();
		final int length = line.length();
		final String[] suffixes = new String[length];
		for (int i = 0; i < length; i++)
			suffixes[i] = line.substring(i);
		sort(suffixes);

		for (int i = 1; i < length; i++) {
			final String s1 = suffixes[i];
			int j = 1;
			while (j <= i) {
				final String s2 = suffixes[i - j];
				final int dist = Math.abs(s1.length() - s2.length());
				if (s1.length() > 1 &&
						s2.length() > 1 &&
						dist > 2) {
					int k = 0;
					int count = 0;
					while (k < s1.length() &&
							k < s2.length() &&
							k < dist &&
							s1.charAt(k) == s2.charAt(k)) {
						if (isValid(s1.charAt(k++))) count++;
						if (count == 2) {
							final int x = Math.max(s1.length(), s2.length());
							final int y = Math.min(s1.length(), s2.length());
							for (int l = length - x + k; l < length - y; l++)
								if(isValid(line.charAt(l))) return "Spell!";
						}
					}

				}
				j++;
			}
		}
		return "Nothing.";
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