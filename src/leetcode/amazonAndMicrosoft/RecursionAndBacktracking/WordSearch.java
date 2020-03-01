package leetcode.amazonAndMicrosoft.RecursionAndBacktracking;
/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.*/
public class WordSearch {

    /*
    * Approach 1: Backtracking
Intuition

This problem is yet another 2D grid traversal problem, which is similar with another problem called 489. Robot Room Cleaner.

Many people in the discussion forum claimed that the solution is of DFS (Depth-First Search). Although it is true that we would explore the 2D grid with the DFS strategy for this problem, it does not capture the entire nature of the solution.

We argue that a more accurate term to summarize the solution would be backtracking, which is a methodology where we mark the current path of exploration, if the path does not lead to a solution, we then revert the change (i.e. backtracking) and try another path.

As the general idea for the solution, we would walk around the 2D grid, at each step we mark our choice before jumping into the next step. And at the end of each step, we would also revert our marking, so that we could have a clean slate to try another direction. In addition, the exploration is done via the DFS strategy, where we go as further as possible before we try the next direction.

pic

Algorithm

There is a certain code pattern for all the algorithms of backtracking. For example, one can find one template in our Explore card of Recursion II.

The skeleton of the algorithm is a loop that iterates through each cell in the grid. For each cell, we invoke the backtracking function (i.e. backtrack()) to check if we would obtain a solution, starting from this very cell.

For the backtracking function backtrack(row, col, suffix), as a DFS algorithm, it is often implemented as a recursive function. The function can be broke down into the following four steps:

Step 1). At the beginning, first we check if we reach the bottom case of the recursion, where the word to be matched is empty, i.e. we have already found the match for each prefix of the word.
Step 2). We then check if the current state is invalid, either the position of the cell is out of the boundary of the board or the letter in the current cell does not match with the first letter of the word.
Step 3). If the current step is valid, we then start the exploration of backtracking with the strategy of DFS. First, we mark the current cell as visited, e.g. any non-alphabetic letter will do. Then we iterate through the four possible directions, namely up, right, down and left. The order of the directions can be altered, to one's preference.
Step 4). At the end of the exploration, we revert the cell back to its original state. Finally we return the result of the exploration.
We demonstrate how it works with an example in the following animation.

Current
4 / 6

Notes

There are a few choices that we made for our backtracking algorithm, here we elaborate some thoughts that are behind those choices.

Instead of returning directly once we find a match, we simply break out of the loop and do the cleanup before returning.

Here is what the alternative solution might look like.


As once notices, we simply return True if the result of recursive call to backtrack() is positive. Though this minor modification would have no impact on the time or space complexity, it would however leave with some "side-effect", i.e. the matched letters in the original board would be altered to #.

Instead of doing the boundary checks before the recursive call on the backtrack() function, we do it within the function.

This is an important choice though. Doing the boundary check within the function would allow us to reach the bottom case, for the test case where the board contains only a single cell, since either of neighbor indices would not be valid.

Complexity

Time Complexity: \mathcal{O}(N \cdot 4 ^ L)O(N⋅4
L
 ) where NN is the number of cells in the board and LL is the length of the word to be matched.
For the backtracking function, its execution trace would be visualized as a 4-ary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 4-nary tree, which is about 4^L4
L
 .
We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.
As a result, overall the time complexity of the algorithm would be \mathcal{O}(N \cdot 4 ^ L)O(N⋅4
L
 ).

Space Complexity: \mathcal{O}(L)O(L) where LL is the length of the word to be matched.
The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is \mathcal{O}(L)O(L).
*/
    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;
    }


    protected boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). check the bottom case. */
        if (index >= word.length())
            return true;

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        // mark the path before the next exploration
        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            if (this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1))
                // return without cleanup
                return true;
        }

        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(index);
        return false;
    }

    //https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2793/
}
