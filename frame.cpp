//Use long message for better random shuffling
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int i=0;
    srand(time(NULL));
    cout<<"\nEnter the message :";
    string s;
    getline(cin,s);
    vector<string>v;
    std::istringstream iss(s);// built in function for breaking the string on spaces
    for(string s;iss>>s;)   // syntax for istringstream
        v.push_back(s);
    int n=v.size();
    int a[n];//for random generations
    for(i=0;i<n;i++)
    {
        a[i]=i; // for assigning sequence number
    }
    cout<<"\nIntermediate message is :\n";
    random_shuffle(&a[0],&a[n]); // built in function for random shuffling
    for(i=0;i<v.size();i++)
    {
        cout<<a[i]; // for printing sequence number
        cout<<v[a[i]]<<" ";//printing message according to sequence number
    }
    i=0;
    cout<<"\noriginal Message :\n";
    for(i=0;i<n;i++)
    {
        cout<<i<<v[i]<<" ";
    }
    cout<<endl;


}
