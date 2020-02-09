package CompetitiveProgrammingQuestions.StringAlgo;

import java.util.Scanner;

public class KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();

        System.out.println(kmpSearch(text,pattern));
    }

    private static int  kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        //preprocess patthern
        int[] lps = getLPS(pattern);
        int i =0; //for text
        int j =0 ; //for pattern
        while (i<n && j<m){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0){
                    j =lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j ==m){
            return i-j;
        }
        return -1;
    }

    private static int[] getLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int i =1,j=0;
        lps[0] =0;
        while(i<pattern.length()){
            //if it mathces move both i and j and put lps[i] =j+1
            if(pattern.charAt(j)==pattern.charAt(i)){
                lps[i]=j+1;
                i++;
                j++;
            }else{
                //check j-1 if its not 0
                if(j!=0){
                    //fix the i
                    j= lps[j-1];
                }else{
                    // fix the j
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }


}
