package backtracking;

import utils.Util;

public class KnightProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int n = 8;
		final int move = 0;

		final int chess[][] = new int[n][n];
		Util.printDP(knight(chess, move, 0, 0));
	}

	private static int[][] knight(int[][] chess, int move, int i, int j) {
		// TODO Auto-generated method stub
		// start with 00,

		// consider all possible moves.
		// there are 8 possible ways a knight can move.
		move = move1(chess, move, i, j);
		knight(chess, move, i, j);

		// move in any one direction.
		// if not visited, fill the step number.
		// recursively check if solution can be reached.
		// if blocking situation comes and not alll squares are filled ,then backtrack.
		// if backtracking leads to 00 , then solution can not be reached.

		return chess;
	}

	private static int move1(int[][] chess, int move, int i, int j) {
		if (i >= 2 && j >= 1) {
			i = i - 2;
			j = j - 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;
	}

	private static int move2(int[][] chess, int move, int i, int j) {
		if (i >= 2 && j <= 6) {
			i = i - 2;
			j = j + 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;

	}

	private static int move3(int[][] chess, int move, int i, int j) {
		if (i <= 5 && j >= 1) {
			i = i + 2;
			j = j - 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;

	}

	private static int move4(int[][] chess, int move, int i, int j) {
		if (i <= 5 && j <= 6) {
			i = i + 2;
			j = j + 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;

	}

	private static int move5(int[][] chess, int move, int i, int j) {
		if (i <= 5 && j <= 6) {
			i = i + 2;
			j = j + 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;
	}

	private static int move6(int[][] chess, int move, int i, int j) {
		if (i <= 5 && j >= 1) {
			i = i + 2;
			j = j - 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;
	}

	private static int move7(int[][] chess, int move, int i, int j) {
		if (i >= 2 && j <= 6) {
			i = i - 2;
			j = j + 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;
	}

	private static int move8(int[][] chess, int move, int i, int j) {
		if (i >= 2 && j >= 1) {
			i = i - 2;
			j = j - 1;
			if (chess[i][j] == 0) {
				chess[i][j] = move + 1;
			}
		}
		return move++;

	}
}
