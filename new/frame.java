import java.util.*;
import java.lang.*;
class labset1
	{
	public static void main(String args[])
		{
		int id=0;
		StringTokenizer st=new StringTokenizer("This is SIT tumakuru");
		int count=st.countTokens();

		Map<Integer,String> hm=new HashMap<Integer,String>();
		while(st.hasMoreTokens())
			{
			hm.put(id,st.nextToken());
			id++;
			}
		System.out.println("sending sequence:");
		for(int i: hm.keySet())
			System.out.println(i+":"+hm.get(i)+"\t");

		ArrayList<Integer>obj=new ArrayList<Integer>();

		for(int i=0;i<count;i++)
			obj.add(i);

		Collections.shuffle(obj);

		System.out.println("\n Received Sequence:");
		for(Integer i:obj)
			System.out.println(i+":"+hm.get(i)+"\t");

		Collections.sort(obj);
		System.out.println("\n sorted sequence:");
		for(Integer i:obj)
			System.out.println(i+":"+hm.get(i)+"\t");
		}
	}
