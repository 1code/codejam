import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	private static Map<Character, String> m = new HashMap<Character, String>();
	static {
		m.put('a', "2");
		m.put('b', "22");
		m.put('c', "222");
		m.put('d', "3");
		m.put('e', "33");
		m.put('f', "333");
		m.put('g', "4");
		m.put('h', "44");
		m.put('i', "444");
		m.put('j', "5");
		m.put('k', "55");
		m.put('l', "555");
		m.put('m', "6");
		m.put('n', "66");
		m.put('o', "666");
		m.put('p', "7");
		m.put('q', "77");
		m.put('r', "777");
		m.put('s', "7777");
		m.put('t', "8");
		m.put('u', "88");
		m.put('v', "888");
		m.put('w', "9");
		m.put('x', "99");
		m.put('y', "999");
		m.put('z', "9999");
		m.put(' ', "0");
	}
	private String solveCase() throws IOException {
		final StringBuilder res = new StringBuilder();
		final String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			final String code = m.get(line.charAt(i));
			final int n = res.length();
			if (n > 0 && code.charAt(0) == res.charAt(n - 1))
				res.append(" ");
			res.append(code);
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