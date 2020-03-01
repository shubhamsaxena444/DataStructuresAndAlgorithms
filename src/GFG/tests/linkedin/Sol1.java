package GFG.tests.linkedin;

import java.util.*;

public class Sol1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List< List<Integer> > input = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(0, 1 ,-1);
        List<Integer> l2 = Arrays.asList(1 ,0 ,-1);
        List<Integer> l3 = Arrays.asList(1 ,1 ,1);

        input.add(l1);
        input.add(l2);
        input.add(l3);

        System.out.println(collectMax(input));
    }

    public static int collectMax(List<List<Integer>> mat) {
        // Write your code here
        int n = mat.size();
        int m = mat.get(0).size();
        //collect maximum on the way to airport using backtracking

        int dir1x[] = new int[]{1,0};
        int dir1y[] = new int[]{0,-1};
        int dir2x[] = new int[]{-1,0};
        int dir2y[] = new int[]{0,1};
        int a = collectMaxToTheAirport( mat,0,0 ,n-1,m-1,n , m,0,dir1x,dir1y);
     //   maxCount =Integer.MIN_VALUE;
       // int b = collectMaxToTheAirport( mat,n-1,m-1 ,0 , 0,n,m,0,dir1x,dir1y);

        //collect maximum on the way back



        return a;

    }
    static int maxCount =Integer.MIN_VALUE;
    private static int collectMaxToTheAirport(List<List<Integer>> mat, int startx, int starty,int destx, int desty, int n, int m,int count,int[] dirx,int[] diry) {

        //basee case,
        if(startx ==destx && starty == desty){
            return hasRider(mat,destx,desty) ? count+1:count;
        }


        int current1,current2;




        current1 =  findCount(mat, startx, starty, destx, desty, n, m, count, dirx, diry, 0);
        current2 = findCount(mat, startx, starty, destx, desty, n, m, count, dirx, diry, 1);
       //  maxCount =Math.max(maxCount,Math.max(current1,current2));

        return Math.max(current1,current2);
    }

    private static int findCount(List<List<Integer>> mat, int startx, int starty, int destx, int desty, int n, int m, int count, int[] dirx, int[] diry, int i) {
        int current;
        int newx= startx+dirx[i];
        int newy= starty+diry[i];
        if(isValid(mat,newx,newy) && hasRider(mat,newx,newy) ){
            //put 0 in place of 1
            mat.get(newx).set(newy,0);
            //recurse
            current = collectMaxToTheAirport(mat,newx,newy,destx,  desty,n,m,count+1,dirx,diry);
//               if( count>maxCount ){
//                   mat.get(newx).set(newy,0);
//                   maxCount = count;
//               }
            //put 1 in place of 0
            mat.get(newx).set(newy,1);

        }else if(isValid(mat,newx,newy) && hasPath(mat,newx,newy)){

            //put 0 in place of 1
          //  mat.get(newx).set(newy,0);
            //recurse
            current = collectMaxToTheAirport(mat,newx,newy,destx,  desty,n,m,count,dirx,diry);
//                if(count>maxCount ){
//
//                    maxCount = count;
//                }
            //put 1 in place of 0
           // mat.get(newx).set(newy,1);

        }else if(isValid(mat,newx,newy) && isBlocker(mat,newx,newy)){

           current = count;
          //  return maxCount;
        }else{
            //return maxCount;
           current = count;
        }
        return current;
    }

    private static boolean hasRider(List<List<Integer>> mat, int newx, int newy) {
        if(mat.get(newx).get(newy)==1)
            return true;
        return false;
    }

    private static boolean isBlocker(List<List<Integer>> mat, int newx, int newy) {
        if(mat.get(newx).get(newy)==-1)
            return true;
        return false;
    }

    private static boolean hasPath(List<List<Integer>> mat, int newx, int newy) {
        if(mat.get(newx).get(newy)>=0)
            return true;
        return false;
    }

    private static boolean isValid(List<List<Integer>> mat, int newx, int newy) {
        int n = mat.size();
        int m = mat.get(0).size();

        if(newx<0 || newx >=n)
            return false;

        if(newy<0||newy>=m)
            return false;
        return true;

    }


}
