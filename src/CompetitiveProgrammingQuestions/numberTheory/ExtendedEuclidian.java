package CompetitiveProgrammingQuestions.numberTheory;

import java.util.Scanner;

//given two no a, b and an equation ax+by = gcd(a,b) .... find x,y
public class ExtendedEuclidian {
    ///x = y1
    //y = x1- (a/b)y1
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("x="+extEuclidian(a,b).x);

        System.out.println("y="+extEuclidian(a,b).y);

        System.out.println("ans="+extEuclidian(a,b).gcd);
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
