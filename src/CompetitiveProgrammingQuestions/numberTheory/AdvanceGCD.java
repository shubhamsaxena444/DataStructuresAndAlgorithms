package CompetitiveProgrammingQuestions.numberTheory;

public class AdvanceGCD {
    /*
    * #include<iostream>
#define ll long long
using namespace std;
string s;
int gcd(int a,int b)
{
    if(b == 0)
    {
        return a;
    }
    else
    {
        return gcd(b,a%b);
    }
}
// big gcd finding technique just find the remainder of that big digit and
// and then find the gcd of the number that is small and the the remainder
int rem(int n)
{
    int p=0;
    for(int i=0;s[i]!='\0';i++)
    {
        p = ((s[i]-'0')+p*10) % n;
    }
    return p;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    //freopen("input.txt","r",stdin);
    //freopen("output.txt","w",stdout);

    int t;
    cin>>t;
    while(t--)
    {
    int n;
    cin>>n;
    cin>>s;
    if(n==0)
    {
         cout<<s<<"\n";
    }
    else
    {
        int ans=rem(n);
        cout<<gcd(n,ans)<<"\n";
    }
    }
    return 0;
}*/
}
