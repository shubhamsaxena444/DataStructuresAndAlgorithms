package leetcode.amazonAndMicrosoft.RecursionAndBacktracking;

import java.util.*;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/
public class GenerateParantheses {
    public List<String> generateParenthesis(int n) {
        //use backtracking
        List<String> res = new ArrayList<>();

        helper(res,n,n,"");
        return res;
    }
    void  helper( List<String> res ,int remopen,int remclose,String s){
        //invalid state
        if(remopen<0 || remclose<remopen)return ;

        if(remopen ==0 && remclose ==0){
            //   FoodSystem.out.println(s);
            res.add(s);
            return ;
        }
        if(remopen >0 ){
            s=s +'(';
            helper(res,remopen-1,remclose,s);
            s= s.substring(0,s.length()-1);
        }
        if(remopen < remclose){
            s=s +')';
            helper(res,remopen,remclose-1,s);
            s= s.substring(0,s.length()-1);
        }
        return;
    }
}
/*Our complexity analysis rests on understanding how many elements there are in generateParenthesis(n). This analysis is outside the scope of this article, but it turns out this is the n-th Catalan number \dfrac{1}{n+1}\binom{2n}{n}
n+1
1
​
 (
n
2n
​
 ), which is bounded asymptotically by \dfrac{4^n}{n\sqrt{n}}
n
n
​

4
n

​
 .

Time Complexity : O(\dfrac{4^n}{\sqrt{n}})O(
n
​

4
n

​
 ). Each valid sequence has at most n steps during the backtracking procedure.

Space Complexity : O(\dfrac{4^n}{\sqrt{n}})O(
n
​

4
n

​
 ), as described above, and using O(n)O(n) space to store the sequence.*/