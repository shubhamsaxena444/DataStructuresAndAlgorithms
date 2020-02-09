package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class Sol1 {

    public static List<String> funWithAnagrams(List<String> text) {
        // Write your code here
        //use a hashmap with key as sorted string , and value as actual string
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        for(String s : text){
            //sort s and put as key and value as actual
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            map.putIfAbsent(String.copyValueOf(chars),s);

        }
        return map.values().stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> l = new ArrayList<>();
        for(int i =0;i<n;i++){
            l.add(sc.nextLine());
        }
        funWithAnagrams(l).forEach(x->{
            System.out.println(x);
        });
    }
}
