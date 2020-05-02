package leetcode.amazonAndMicrosoft.arraysAndString;
/*Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701*/
import java.util.*;
public class ExcelSheetNumber {
    public static int titleToNumber(String s) {
        //
        int n =s.length();
        if(n==0)return 0;
        if(n==1){
            return s.charAt(0)-'A'+1;
        }
        int res =0;
        int base =26;
        for(int i =0;i<n;i++){
            res+=Math.pow(base,n-i-1) * (s.charAt(i)-'A'+1);
        }
        return res;
    }
    class Interval{
        int s;
        int e;
        Interval(int s,int e){
            this.s = s;
            this.e = e;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> res =new  ArrayList<>();
        Stack<Interval> ans = new Stack<>();
        for(int i =0;i<intervals.length;i++){
            res.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        //sort the res
        Collections.sort(res, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.s-o2.s;
            }
        });
        for(Interval i : res){
            if(ans.isEmpty()){
                //push
                ans.push(i);
            }else if(ans.peek().e >= i.s){
                Interval temp = ans.pop();
                //merge
                ans.push(new Interval(temp.s,i.e));
            }else{
                //push
                ans.push(i);
            }
        }
        int answer[][] = new int[ans.size()][2];
        int ind=0;
        for(Interval i : ans){
            answer[ind][0] =i.s;
            answer[ind][1] =i.e;
            ind++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ACF"));
    }
}
