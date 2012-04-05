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

	private String solveCase() throws IOException {
		String s = next();
		s = s.replace('(', '[');
		s = s.replace(')', ']');
		int res = 0;
		for (final String w : words) {
			if (w.matches(s)) res++;
		}
		return String.valueOf(res);
	}

	List<String> words = new ArrayList<String>();
	private void solve() throws IOException {
		final int wordLength = nextInt();
		final int wordNumber = nextInt();
		final int testNumber = nextInt();
		for (int i = 0; i < wordNumber; i++) {
			words.add(next());
		}
		debug(words);
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