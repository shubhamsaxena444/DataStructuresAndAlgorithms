package string;

public class Strstr {

    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }else if( needle.isEmpty() ){
            return 0;
        }else if(haystack.isEmpty()){
            return -1;
        }

        for(int i =0 ;i <= haystack.length()-needle.length(); i++){
            int j;
            for(j = 0 ;j<needle.length();j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }

            }
            if(j ==needle.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("lhello","ll"));
    }
}
