package leetcode.googleAndFacebook.interviewProcess;

public class LicenceKeyFormatting {
    public static String licenseKeyFormatting(String s, int k) {

        int n = s.length();

        String parts[] = s.split("-");
        StringBuilder newString = new StringBuilder("");
        for(String part : parts){
            newString.append(part.toUpperCase());
        }
        int size = newString.length();
        if(size<=k){
            return newString.toString();
        }else{
            int chunksize = size/k;
            int rem = size%k;
            int numberOfDash;
            if(rem !=0){
                numberOfDash = chunksize;
            }else{
                numberOfDash = chunksize-1;
            }
            int j =size-1;
            int chunkcount =0;
            /*
            ABCDE, 2
            01234
            A-BC-DE
            0123456
            */
            char[] temp = new char[size+numberOfDash];
            for(int i = temp.length-1;i>=0;){


                if(chunkcount == k){
                    temp[i] = '-';
                    i--;
                    chunkcount =0;
                }else{

                    temp[i] = newString.charAt(j);
                    i--;
                    j--;
                    chunkcount++;
                }

            }
            return new String(temp);
        }


    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
    }
}
