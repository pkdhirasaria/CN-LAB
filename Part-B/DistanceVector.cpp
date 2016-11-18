#include <iostream>
#include <bits/stdc++.h>
#define fr(a,b) for(i=a;i<=b;i++)
using namespace std;

void kstra(int n,int v,int cost[10][10],int dist[])
	{
		int i,u=0,count,w,min;
		bool flag[10];
		for(i=1;i<=n;i++)
		{
			flag[i]=false;
			dist[i]=cost[v][i];
		}
		flag[v]=true;
		count=2;
		while(count<=n)
		{
			min=999;
			for(w=1;w<=n;w++)
				if((dist[w]<min)&&(!flag[w]))
				{
					min=dist[w];
					u=w;
				}
			flag[u]=true;
			count++;
			for(w=1;w<=n;w++)
				if((dist[u]+cost[u][w]<dist[w])&&!flag[w])
					dist[w]=dist[u]+cost[u][w];
		}
	}

int main()
{
    int n,v,i,j;
    int cost[10][10];
    int dist[10];
    cout<<"\nEnter the number of nodes : ";
    cin>>n;
    cout<<"\nEnter the cost of the matrix : ";
    fr(1,n)
    {
        for(j=1;j<=n;j++)
        {
            cin>>cost[i][j];
            if(cost[i][j]==0)
                cost[i][j]=999;
        }
    }
    cout<<"\nEnter the source vertex : ";
    cin>>v;
    kstra(n,v,cost,dist);
    cout<<"Shorter path from : \n";
		for(j=1;j<=n;j++)
			if(j!=v)
				cout<<v<<"-->"<<j<<"::"<<dist[j]<<"\n";
    return 0;
}
