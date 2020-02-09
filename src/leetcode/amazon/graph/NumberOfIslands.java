package leetcode.amazon.graph;

public class NumberOfIslands {
    boolean vis[][] ;//= new boolean[n][m];
    int xd[] = new int[]{0,0,1,-1};
    int yd[] = new int[]{1,-1,0,0};
    int n ,m;
    public int numIslands(char[][] grid) {


        //find no of connected components
        //perform dfs
        //an edge exist if, the next hor,vert combination is 1 and not visited
        n = grid.length;
        if(n==0 )return 0;
        m = grid[0].length;


        vis = new boolean[n][m];
        int count =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                //if grid[i][j ]  == 1 and it aion't vissited,call dfs
                if(grid[i][j] == '1' && !vis[i][j]){
                    count+=1;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid,int x,int y){
        vis[x][y] =true;

        for(int i =0;i<4;i++){
            int newX = x+xd[i];
            int newY =y +yd[i];
            if(newX>=0 && newX<n && newY>=0 && newY<m && !vis[newX][newY] && grid[newX][newY] == '1'){
                dfs(grid,newX,newY);
            }
        }
    }
}
