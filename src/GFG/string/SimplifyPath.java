package GFG.string;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String p) {
        //start from 0th index,

        //if stack is empty and / comes, put it
        Stack<Character> s = new Stack<>();
        int n = p.length();
        for(int i=0;i<n;i++){
            char cur = p.charAt(i);
            char next = i+1<n ? p.charAt(i+1) : '#';

            if(cur =='/' && next == '/'){
                if(s.empty() || s.peek()!='/')
                s.push(cur);
                i++;
            }else if(cur == '.' && next !='.'){
                i++;
            }else if(cur == '.' && next =='.' && !s.isEmpty()){
                s.pop();
                if(!s.isEmpty() && s.size()!=1){
                    s.pop();
                }
                i++;
            }else{
                s.push(cur);
            }

        }
        String res="";

        while(!s.isEmpty()){
            res = s.pop() + res;
        }
        return res=="" ?"/":res.charAt(res.length()-1) =='/'?res.substring(0,res.length()-1):res;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

}
