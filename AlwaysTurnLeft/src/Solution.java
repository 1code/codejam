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

	private static final int NORTH = 0;
	private static final int SOUTH = 1;
	private static final int WEST = 2;
	private static final int EAST = 3;
	private static final int SIZE = 10000;
	private static byte[][] board;
	private static int row = -1, col = SIZE;
	int min_row = 0;
	int max_row = 0;
	int min_col = SIZE;
	int max_col = SIZE;

	private int turn(final int f, final char t) {
		if (t == 'L') {
			switch (f) {
			case NORTH:
				return WEST;
			case SOUTH:
				return EAST;
			case WEST:
				return SOUTH;
			case EAST:
				return NORTH;
			}
		}
		else if (t == 'R') {
			switch (f) {
			case NORTH:
				return EAST;
			case SOUTH:
				return WEST;
			case WEST:
				return NORTH;
			case EAST:
				return SOUTH;
			}
		}
		return f;
	}

	private int back(final int f) {
		switch (f) {
		case NORTH:
			return SOUTH;
		case SOUTH:
			return NORTH;
		case WEST:
			return EAST;
		case EAST:
			return WEST;
		}
		return f;
	}

	private void go(final int f) {
		if (row >= 0) board[row][col] |= (1 << f);
		switch (f) {
		case NORTH:
			row--;
			break;
		case SOUTH:
			row++;
			break;
		case WEST:
			col--;
			break;
		case EAST:
			col++;
			break;
		}
	}

	private int process(int f, final String s) {
		for (int i = 0; i < s.length(); i++) {
			final char c = s.charAt(i);
			if (c == 'R' || c == 'L') {
				f = turn(f, c);
			}
			else if (c == 'W') {
				go(f);
				if (i != s.length() - 1) {
					if (col < min_col) min_col = col;
					if (col > max_col) max_col = col;
					if (row > max_row) max_row = row;
				}
			}
//			debug(i, c, row, col, f);
		}
		return f;
	}
	private String solveCase() throws IOException {
		final String entrance_to_exit = next();
		final String exit_to_entrance = next();
		row = -1; col = SIZE;
		min_row = 0; max_row = 0;
		min_col = SIZE; max_col = SIZE;
		int f = SOUTH;
		board = new byte[SIZE][2*SIZE+1];
		f = process(f, entrance_to_exit);
		f = process(back(f), exit_to_entrance);

//		debug(min_row, max_row);
//		debug(min_col, max_col);
		final StringBuilder res = new StringBuilder("\n");
		for (int row = min_row; row <= max_row; row++) {
			for (int col = min_col; col <= max_col; col++) {
				res.append(Integer.toString(board[row][col] & 0xff, 16));
			}
			res.append('\n');
		}
		return res.toString();
	}

	private void solve() throws IOException {
		final int testNumber = nextInt();
		for (int test = 0; test < testNumber; test++) {
			final String result = "Case #" + (test + 1) + ":" + solveCase();
			pw.print(result);
			System.out.print(result);
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