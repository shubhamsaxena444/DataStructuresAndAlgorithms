package GFG.tests.linkedin;

import java.util.*;

public class Sol2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    public static int connectedSum(int n, List<String> edges) {
        // Write your code here


        int am[][] =new int[n][n];
        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        for(String pair :edges){
            String[] temp = pair.split(" ");

            //convert string to number
            int num1 = Integer.parseInt(temp[0]);
            int num2 = Integer.parseInt(temp[1]);
            int a = (num1)-1;
            int b = (num2)-1;
            am[a][b] =1;
            am[b][a] =1;
        }
        List<List<Integer>> allPaths = getConnectedComponents(n, am);

        int res =0;
            for(List<Integer> comp: allPaths){
                int size = comp.size();
                int val = (int) Math.ceil(Math.sqrt(size));
                res+=val;
            }
        return res;
    }

    private static List<List<Integer>> getConnectedComponents(int v, int[][] am) {
        List<List<Integer>> allPaths = new ArrayList<>();
//        BFS(am,v,e);

        boolean vis[] =new boolean[v];
        for(int i =0;i<v;i++){
            if(vis[i]  == false) {
                List<Integer> path = new ArrayList<>();
                DFS(am, v, i, vis, path);
                allPaths.add(path);
            }
        }           //if all vis then connected else false
        return allPaths;
    }

    private static void DFS(int[][] am, int v, int node, boolean[] vis, List<Integer> path) {
        vis[node] =true;
        path.add(node);
        for(int i=0;i<v;i++){
            //for each adj and not visited
            if(am[node][i] == 1 && !vis[i] ){
                DFS(am,v,i,vis,path);
            }
        }
        return;
    }


}
