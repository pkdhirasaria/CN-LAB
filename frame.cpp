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
int main()
{
    int i=0;
    cout<<"\nEnter the message :";
    string s;
    getline(cin,s);
    vector<string>v;
    int k=0;
    std::istringstream iss(s);
    for(string s;iss>>s;)
        v.push_back(s);
     int n=v.size();
    int a[n];//for random generations
    for(i=0;i<n;i++)
    {
        a[i]=i;
    }
    cout<<"Intermediate message is :\n";
    fr(0,n)
    {
        cout<<a[i]<<v[i]<<" ";
    }
    cout<<endl;

    random_shuffle(&a[0],&a[n]);
    i=0;
    //print(a,n);
    for(i=0;i<v.size();i++)
    {
        cout<<a[i];
        cout<<v[a[i]]<<" ";
    }
}
