import java.util.Scanner;
public class CRC {
	public static void main(String args[]){
		int gp = 69665, rem,j=0;
		Scanner ip = new Scanner (System.in);
		int data;
		System.out.println("Enter dataword to send\n");
		data=ip.nextInt();
		data = data<<16;
		int temp=data;
		while(temp !=0){
			j++;
			temp=temp>>1;
		}
		temp=data;
		int ctemp=gp;
		while(temp>=gp)
		{
			ctemp=gp<<(j-17);
			rem=temp^ctemp;
			temp=rem;
			j=0;
			while(rem !=0){
				j++;
				rem=rem>>1;
			}
		}
		System.out.println("The remainder is : "+temp);
		data=data|temp;
		System.out.println("The codeword is : "+data) ;
		System.out.println("Enter codeword received at receiver side\n");
		data=ip.nextInt();

		data=data|temp;
		temp=data;
		j=0;
		while(temp !=0){
			j++;
			temp=temp>>1;
		}
		temp=data;
		ctemp=gp;
		while(temp>=gp)
		{
			ctemp=gp<<(j-17);
			rem=temp^ctemp;
			temp=rem;
			j=0;
			while(rem !=0){
				j++;
				rem=rem>>1;
			}
		}
		if(temp==0){
			System.out.println("Codeword is CORRECT\nThe remainder is : "+Integer.toBinaryString(temp));
		}
		else
			System.out.println("The Codeword is not correct \nRemainder is : "+Integer.toBinaryString(ctemp));
	}
}


