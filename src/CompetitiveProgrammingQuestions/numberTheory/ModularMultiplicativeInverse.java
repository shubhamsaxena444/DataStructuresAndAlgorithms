package CompetitiveProgrammingQuestions.numberTheory;

import java.util.Scanner;

//(a.b)%m =1 , a and m are given , find b   (what is the mod mul inverse of a under mod m ?), i.e b
public class ModularMultiplicativeInverse {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int a = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("modMultInverse="+modMultInverse(a,m));

    }


    //(a.b)%m =1 can be reduced to a.b +m.Q = 1  .. where (a,m) are co primes, therefore we can use ext euclidian to find b , i.e x
        // ab = 1 mod m
    static int modMultInverse(int a , int m){

        Triplet small = extEuclidian(a,m);

        return small.x;
    }
    static class Triplet{
        public Triplet() {
        }

        int gcd;
        int x,y;

        public Triplet(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }
    //here a is always a>b
    private static Triplet extEuclidian(int a, int b) {
        if(b == 0){
            Triplet t = new Triplet();
            t.gcd = a;
            t.x = 1;
            t.y = 0;
            return t;
        }
        Triplet small = extEuclidian(b,a%b);
        int x = small.y;
        int y = small.x - (a/b)*small.y;
        int ans = small.gcd;
        return new Triplet(ans,x,y);
    }
}
