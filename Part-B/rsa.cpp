#include <bits/stdc++.h>
using namespace std;
#define fr(a,b) for(i=a;i<b;i++)
#define rep(a,b) for(i=a;i>=b;i--)
#define f first
#define s second
#define inp(a,n) fr(i,n) cin>>a[i]
#define print(a,n) fr(i,n) {cout << a[i] << " ";} cout << endl
#define ll long long
#define my(type) (char *)(&type+1)-(char *)(&type)
int prime(int n)
{
    int i;
    for(i=2;i<=n/2;i++)
    {
        if(n%i==0) return 1;
    }
    return 0;
}
int gcd(int x,int y)
{
    	return y==0? x:gcd(y,x%y);
}
int encrypt(int x,int e,int n)
{
    int i,rem=1;
    for(i=0;i<e;i++)
    {
        rem=(rem*x)%n;
    }
    return rem;
}


int main()
{

    // cin>>t;
    string msg;
    cout<<"\nEnter the message : ";

        getline(cin,msg);


    //while(t--)
    int p,q,z,n,e,d;
   // string msg;
    do{
        cout<<"\nEnter the two prime number : ";
        cin>>p>>q;
    }while (prime(p) || prime(q));
    n=p*q;
    z=(p-1)*(q-1);
    do
    {	printf("\nEnter prime value of e relative to %d(z):",z);
        scanf("%d",&e);
    }while(gcd(e,z)!=1 || e>n);
    for(d=2;d<z;d++)
        if((e*d)%z == 1)
            break;
    //printf("\n\tPublic Key\t: {%d,%d}",e,n);
//    printf("\n\tPrivate Key\t: {%d,%d}",d,n);
//    cin>>msg;

    int en[1000];
    for(int i=0;i<msg.length();i++)
    {
        en[i]=encrypt(msg[i]-'a',e,n);
    }
    cout<<"\nEncrypted message is: ";
    for(int i=0;i<msg.length();i++)
    {
        cout<<en[i]<<" ";
    }
    string plain;
    for(int i=0;i<msg.length();i++)
    {
        plain+=(encrypt(en[i],d,n)+'a');
    }
    cout<<"\nPlain Text is: "<<plain;

    return 0;
}
