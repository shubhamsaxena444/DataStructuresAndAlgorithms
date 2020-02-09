package string;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }

        for(int i = 0, j = s.length()-1; i<j ; ){
            if((isAlphanumeric(s.charAt(i)) && isAlphanumeric(s.charAt(j)) && (s.charAt(i) == s.charAt(j) || isSameIgnoreCase(s.charAt(i),s.charAt(j))))
                    || (!isAlphanumeric(s.charAt(i)) && !isAlphanumeric(s.charAt(j)))){
                i++;
                j--;
            }else if(!isAlphanumeric(s.charAt(i))){
                i++;
            }else if(!isAlphanumeric(s.charAt(j))) {
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    private static boolean isAlphanumeric(char c){
        if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }

    private static boolean isSameIgnoreCase(char c1, char c2){
        if(isChar(c1) && isChar(c2) && ( c1 - 'a' == c2 - 'A' || c1 - 'A' == c2 - 'a')){
            return true;
        }
        return false;
    }

    private static boolean isChar(char c){
        if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("1b1"));
    }

}
