import java.util.Scanner;

public class Dist{
static void djikstra(int n,int v,int cost[][],int dist[])
{
	int i,u=0,count,w,min;
	boolean flag[]=new boolean[10];
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
			if((dist[w]<min) && (!flag[w]))
			      {
				     min=dist[w];
				     u=w;
			      }

		flag[u]=true;
		count++;

		for(w=1;w<=n;w++)
		       if((dist[u]+cost[u][w]<dist[w]) && !flag[w])
				  dist[w]=dist[u]+cost[u][w];
	}
}

public static void main(String[] args)
{
	int n,v,i,j;
	int cost[][]=new int[10][10];
	int dist[]=new int[10];
	System.out.println("Enter the no. of nodes\n");
	Scanner input=new Scanner(System.in);
	n=input.nextInt();

	System.out.println("Enter the cost matrix\n");
	for(i=1;i<=n;i++)
	    for(j=1;j<=n;j++)
	    {
		cost[i][j]=input.nextInt();
		if(cost[i][j]==0)
		    cost[i][j]=999;
	    }

	System.out.println("Enter the source vertex\n");
	v=input.nextInt();
	djikstra(n,v,cost,dist);

	System.out.println("Shortest path from\n");
	for(j=1;j<=n;j++)
	   if(j!=v)
		   System.out.println(v+" --> "+j+"::"+dist[j]);

}
}
