package leetcode.googleAndFacebook.arrays;

public class SumDivisibleByK {
    public static int countKdivPairs(int A[], int n, int K)
    {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int freq[] = new int[K];

        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            ++freq[A[i] % K];

        // If both pairs are divisible by 'K'
        int sum = freq[0] * (freq[0] - 1) / 2;

        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= K / 2 && i != (K - i); i++)
            sum += freq[i] * freq[K - i];
        // If K is even
        if (K % 2 == 0)
            sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
        return sum;
    }
    int mod=1000000007;
    public int factorial(int n)
    {
        int a=1;
        if(n<=1)
            return n;
        return (n*factorial(n-1))%mod;
    }
    int calvalue(int n,int m)
    {
        return (n*m)%mod;
    }
    public int solve(int[] A, int B) {
        int moda[]=new int[B];

        for(int i=0;i<A.length;i++)
        {
            moda[A[i]%B]++;
        }
        int i=0,j=B-1;
        int ans= factorial(moda[0])/((2*(moda[0]-2))%mod);
        i=1;
        while(i<j)
        {
            ans+=calvalue(moda[i],moda[j]);
            i++;
            j--;
        }


        if(B%2==0)
        {
            ans+= factorial(moda[i])/((2*(factorial(moda[i]-2)))%mod);
        }
        return ans;
    }
    public static void main(String[] args)
    {

        //1,7
        //2,6
        //
        int A[] = {1,2,3,4,5,6,7,8};
        int n = 8;
        int K = 4;
        System.out.print(countKdivPairs(A, n, K));
    }
}
