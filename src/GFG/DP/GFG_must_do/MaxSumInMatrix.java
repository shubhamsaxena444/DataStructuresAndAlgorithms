package GFG.DP.GFG_must_do;
/*Given a matrix of N * M. Find the maximum path sum in matrix. The maximum path is sum of all elements from first row to last row where you are allowed to move only down or diagonally to left or right. You can start from any element in first row.

Examples:

Input : mat[][] = 10 10  2  0 20  4
                   1  0  0 30  2  5
                   0 10  4  0  2  0
                   1  0  2 20  0  4
Output : 74
The maximum sum path is 20-30-4-20.

Input : mat[][] = 1 2 3
                  9 8 7
                  4 5 6
Output : 17
The maximum sum path is 3-8-6.*/
public class MaxSumInMatrix {
    public static int N = 4, M = 6;

    // Function to calculate max path in matrix
    static int findMaxPath(int mat[][])
    {
        // To find max val in first row
        int res = -1;
        for (int i = 0; i < M; i++)
            res = Math.max(res, mat[0][i]);

        for (int i = 1; i < N; i++)
        {
            res = -1;
            for (int j = 0; j < M; j++)
            {
                // When all paths are possible
                if (j > 0 && j < M - 1)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            Math.max(mat[i - 1][j - 1],
                                    mat[i - 1][j + 1]));

                    // When diagonal right is not possible
                else if (j > 0)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            mat[i - 1][j - 1]);

                    // When diagonal left is not possible
                else if (j < M - 1)
                    mat[i][j] += Math.max(mat[i - 1][j],
                            mat[i - 1][j + 1]);

                // Store max path sum
                res = Math.max(mat[i][j], res);
            }
        }
        return res;
    }

    // driver program
    public static void main (String[] args)
    {
        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };

        System.out.println(findMaxPath(mat));
    }
}