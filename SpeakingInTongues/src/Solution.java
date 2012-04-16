import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}
	static char[] maps = {'y', 'h', 'e', 's', 'o', 'c', 'v', 'x', 'd', 'u', 'i',
		'g', 'l', 'b', 'k', 'r', 'z', 't', 'n', 'w', 'j', 'p', 'f', 'm', 'a', 'q'};
	private String solveCase() throws IOException {
		String line = nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == ' ') {
				sb.append(' ');
			}
			else {
				sb.append(maps[c-'a']);
			}
		}
		return String.valueOf(sb.toString());
	}

	private void solve() throws IOException {
		final int T = nextInt();
		for (int test = 0; test < T; test++) {
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