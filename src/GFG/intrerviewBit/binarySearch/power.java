package GFG.intrerviewBit.binarySearch;
/*
* Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.*/
public class power {
    public static int pow(int x, int n, int d) {
       /* if(n==0)return 1;

        if(n%2==1){
            return ( ((x%d) * (pow(x,n/2,d)%d))%d * ( pow(x,n/2,d)%d))%d;
        }else{
            return ( (pow(x,n/2,d)%d) * (pow(x,n/2,d)%d)  )%d;
        }*/

        if (n == 0) return 1 % d;

        long ans = 1, base = x;
        while (n > 0) {
            // We need (base ** n) % p.
            // Now there are 2 cases.
            // 1) n is even. Then we can make base = base^2 and n = n / 2.
            // 2) n is odd. So we need base * base^(n-1)
            if (n % 2 == 1) {
                ans = (ans * base) % d;
                n--;
            } else {
                base = (base * base) % d;
                n /= 2;
            }
        }
        if (ans < 0) ans = (ans + d) % d;
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(pow(2,3,10));
    }
}
