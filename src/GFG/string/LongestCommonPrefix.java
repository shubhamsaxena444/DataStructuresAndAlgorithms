package string;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        int i;
        for(i =0;i<strs[0].length() ;){
            int j;
            for(j =0;j< strs.length ;j++){
                try{
                    if(j< strs.length-1 && strs[j].charAt(i) != strs[j+1].charAt(i)){
                        break;
                    }
                }catch(StringIndexOutOfBoundsException a){
                    return strs[0].substring(0,i);
                }
            }
            if(j == strs.length){
                i++;
            }else{
                break;
            }
        }
        return strs[0].substring(0,i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","f","flight"}));
    }

}
