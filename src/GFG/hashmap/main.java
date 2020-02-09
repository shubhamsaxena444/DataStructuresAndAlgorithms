package hashmap;

import java.util.HashMap;

public class main {
    static boolean areFollowingPatterns(String[] strings, String[] patterns) {

        HashMap<String,String> hmstr = new HashMap<>();
        HashMap<String,String> hmpat = new HashMap<>();

        int n =strings.length;
        int m = patterns.length;
        if(m != n)return false;
        for(int i =0;i<n;i++){
            //if already present, and curr pattern[i] != prev value return false;
            if((hmstr.get(strings[i]) !=null && hmstr.get(strings[i]) != patterns[i])
                    ||(hmpat.get(patterns[i]) !=null && hmpat.get(patterns[i]) != strings[i]))
            {
                return false;
            }
            hmstr.put(strings[i],patterns[i]);
            hmpat.put(patterns[i],strings[i]);

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areFollowingPatterns(new String[]{"cat","dog","dog"},new String[]{"a","b","b"}));
    }
}
