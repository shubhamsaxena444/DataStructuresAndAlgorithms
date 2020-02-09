package leetcode.uber.amazon.trees.graph;

import java.util.*;

public class DirectedCycle {
    // boolean hasCycle =false;
    boolean vis[] ;
    boolean recStack[] ;
    // Stack<Integer> recStack = new Stack<>();
    public boolean canFinish(int n, int[][] dep) {
        //it has to be DAG
        //check for cycle in directed graph using dfs and recS
        //represent in aL
        if(n<=1 || dep.length ==0)return true;
        List<List<Integer>> g = new ArrayList<>();
        for(int i =0;i<n;i++){
            g.add(i,new ArrayList<Integer>());
        }
        for(int i =0;i<dep.length;i++){
            int[] pair = dep[i];
            g.get(pair[1]).add(pair[0]);
        }
        //use stack based solution
        vis = new boolean[n];
        recStack =new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                if(hasCycle(g,i))return false;
            }
        }

        return true;
    }

    boolean hasCycle(List<List<Integer>> g, int s){
        //if rec stack already contains

        if(recStack[s]){
            //   if presetnt in rec stack,, means ther is a cyvle and a back edge
            return true;
        }

        if(vis[s]){
            return false;
        }
        vis[s] =true;
        recStack[s] = true;
        for(Integer adj : g.get(s)){

            if(hasCycle(g,adj))return true;

        }
        recStack[s]=false;
        return false;
    }

    public static void main(String[] args) {
        DirectedCycle d = new DirectedCycle();
        int[][] a = new int[1][2];
        a[0] =new int[]{0,1};
        System.out.println( d.canFinish(2,a));

    }
}
