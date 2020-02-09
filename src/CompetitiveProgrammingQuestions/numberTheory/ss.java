package CompetitiveProgrammingQuestions.numberTheory;

class solution {


    int[][][] dp;
    public  int solve(String a,String b,String c){
        //write your code here
        //let i ,j ,k be the indices representing the string a,b,c respectively
        int x =0,y=0,z=0;
        dp = new int[a.length()+1][b.length()+1][c.length()+1];
        for(int i =0;i<=a.length();i++){
            for(int j =0;j<=b.length();j++){
                for(int k =0;k<=c.length();k++){
                    dp[i][j][k] =-1;
                }
            }
        }
        return  aux(a,x,b,y,c,z);
    }
    int count =0;
    private  int aux(String a, int x, String b, int y, String c, int z) {
        //base case is if c has reached its length
        if(z>=c.length() ){
            return 1;
        }

        if(x>=a.length() && y>=b.length()){
            return 0;
        }

        if(dp[x][y][z]!=-1){
            return dp[x][y][z];
        }

        //find c[k] in a , and every time you find inc the count;
        for(int i =x;i<a.length();i++){
            if(c.charAt(z) == a.charAt(i)){
                count += aux(a,i+1,b,y,c,z+1);
            }
        }

        //find c[k] in b , and every time you find inc the count;
        for(int j =y;j<b.length();j++){
            if(c.charAt(z) == b.charAt(j)){
                count += aux(a,x,b,j+1,c,z+1);
            }
        }
        dp[x][y][z] = count;
        return count;
    }
}
