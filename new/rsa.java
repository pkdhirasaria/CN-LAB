import java.util.*;

class RSA
	{
	public static void main(String args[])
		{
		int p,q,n,z,e,num,d1;
		int big;
		int i;
		int c1=0,c2=0;
		int n1,n2;
		int r=0;
		double d,cipher;
		Scanner input=new Scanner(System.in);
		System.out.println("enter any prime numbers : ");
		p=input.nextInt();
		q=input.nextInt();
		if(p>q)
		big=p;
		else
		big=q;
		for(i=1;i<=big;i++)
			{
			if(p%i==0)
				++c1;
			if(q%i==0)
				++c2;
			}


		if(c1!=2 || c2!=2)
			{
			System.out.println("invalid pair of prime numbers");
			System.exit(0);
			}

		n=p*q;
		z=(p-1)*(q-1);
		System.out.println("z is"+z);

		System.out.println("enter an integer e, 1<e<"+z+" such that GCD(e,"+z+")=1");
		e=input.nextInt();
		n1=e;
		n2=z;
		while(n2!=0)
			{
			r=n1%n2;
			n1=n2;
			n2=r;
			}
		int gcd=n1;
		if((e<1 || e>z)||(gcd!=1))
			{
			System.out.println("invalid selection of e");
			System.exit(0);
			}
		d=(Math.pow(e,-1))*(Math.abs(z));

		d1=(int)Math.ceil(d);

		System.out.println("value of d is "+d1);

		if((d1<1 || d1>z)||(e*d1==(Math.abs(z))))
			{
			System.out.println(d1+" is less than 1 or greater than "+z);
			System.exit(0);
			}
		else
			{
			System.out.println("public key is ("+n+","+e+")");
			System.out.println("private key is ("+n+","+d1+")");
			}
		System.out.println("enter a number to be encrypted : ");
		num=input.nextInt();
		cipher=(Math.pow(num,e)%n);

		System.out.println("cipher text is :"+cipher);

		System.out.println("original text is :"+((Math.pow(cipher,d1))%n));
		}
	}

