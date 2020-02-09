package arrays;
/*Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number for which the second occurrence has the minimal index. In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence has a smaller index than the second occurrence of the other number does. If there are no such elements, return -1.*/
public class FirstDuplicate {
    int firstDuplicate(int[] a) {


        for(int i =0;i<a.length;i++){
            //mark it negative
            if(a[Math.abs(a[i])-1]<0){
                return Math.abs(a[i]);
            }
            a[Math.abs(a[i])-1] =  -1 * a[Math.abs(a[i])-1];

        }
        return -1;

    }

    public static void main(String[] args) {
        char[] test = new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        int n =test.length;
        reverseWrd(test,0,test.length-1);
        int start =0,end;
        while (test[start]==' ')start++;
        for( end = start+1;end<n;end++){
            if(test[end]==' '){
                reverseWrd(test,start,end-1);
                while(end<n && test[end] == ' ')end++;
                start =end;
            }
        }
        if(end == n){
            reverseWrd(test,start,end-1);
        }
        System.out.println(test);
    }

    private static void reverseWrd(char[] test, int start, int end) {
        for(int i =start,j=end;i<j;i++,j--) {
            char temp = test[i];
            test[i] =test[j];
            test[j] =temp;
        }
    }
}
