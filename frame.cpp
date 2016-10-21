#include <bits/stdc++.h>

using namespace std;

int main()
{
    srand(time(NULL));
    pair<int,string>a[200];
    cout<<"\nEnter the message : ";
    string s;
    getline(cin,s);
    int i,j;
    int k=0;
    j=0;
    s+=' ';
    int n=s.length();
/*    cout<<s.substr(0,5)<<endl;
    cout<<s.substr(5,3)<<endl;
    cout<<s.substr(8,3)<<endl;*/
    int count=0;
   for(i=0;i<n;i++)
    {
        count++;
        if(s[i]==' ')
        {
            a[k].second=s.substr(j,count);
            a[k].first=k;
        //    cout<<a[k].first<<"-->"<<a[k].second<<"\n";
            k++;
            j=i+1;
            count=0;
        }
    }
    int c[200]={0};
    cout<<"Intermediate message is : ";
    int flag=1;
    for(i=0;;i++)
    {
        int value=rand()%(k);
        if(c[value]==0)
            c[value]=1;
        else
            c[value]=-1;
        flag=1;
        for(j=0;j<k;j++)
        {
            if(c[j]==1)
            {
                 cout<<a[value].first<<""<<a[value].second<<" ";
                 c[j]=999;
            }
            else if(c[j]==0)
                flag=0;
        }
        if(flag==1)
            break;

    }
    cout<<"\nOriginal Message is : ";
    for(i=0;i<k;i++)
    {
        cout<<a[i].first<<""<<a[i].second<<" ";
    }

    return 0;
}

