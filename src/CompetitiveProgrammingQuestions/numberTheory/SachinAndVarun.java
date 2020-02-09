package CompetitiveProgrammingQuestions.numberTheory;

import java.util.Scanner;

public class SachinAndVarun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long a[] = new long[t];
        long b[] = new long[t];
        long d[] = new long[t];
        for (int i =0;i<t;i++){
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
            d[i] = sc.nextLong();
        }
        for (int i =0;i<t;i++) {
            System.out.println(solve(a[i],b[i],d[i]));
        }

    }

    private static long solve(long a, long b, long d) {
        // ans = n+1
        // n =( d/b - y1)/a
        // y1 = (d/b)%a  == (d%a *modmulInv(b,a))%a

        //base cases
        long gcd = extEuclidian(a,b).gcd;
        if(d%gcd !=0){
            return 0;
        }
        if(d == 0){
            return 1;
        }
        a/=gcd;
        b/=gcd;
        d/=gcd;

        long y1 = ((d%a) * modMultInverse(b,a))%a;
        long firsValue = d/b;
        if(d< y1*b){
            return 0;
        }
        long n =(firsValue-y1)/a;
        return n+1;
    }

    //(a.b)%m =1 can be reduced to a.b +m.Q = 1  .. where (a,m) are co primes, therefore we can use ext euclidian to find b , i.e x
    // ab = 1 mod m
    static long modMultInverse(long a , long m){

        Triplet small = extEuclidian(a,m);

        return (small.x % m +m )%m;
    }
    static class Triplet{
        public Triplet() {
        }

        long gcd;
        long x,y;

        public Triplet(long gcd, long x, long y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }
    //here a is always a>b
    private static Triplet extEuclidian(long a, long b) {
        if(b == 0){
            Triplet t = new Triplet();
            t.gcd = a;
            t.x = 1;
            t.y = 0;
            return t;
        }
        Triplet small = extEuclidian(b,a%b);
        long x = small.y;
        long y = small.x - (a/b)*small.y;
        long ans = small.gcd;
        return new Triplet(ans,x,y);
    }
}
