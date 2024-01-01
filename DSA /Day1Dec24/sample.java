package day1Dec24;

public class sample {
public static void main(String[] args) {
	// 1 2 4 5 10 20
	int n=100; 
	int i=1;
	while(i*i<=n)            // 1 2 4 5 10 O(sqrt(n)+1)
	{
		if(n%i==0)
			System.out.print(i+" ");
		i++;
	}
	System.out.println();
	System.out.println(i); //sqrt(n)
	while(i>0)     // 20 25 50 100  
	{			
		if(n%i==0 && n/i != i)	
		System.out.print(n/i+" ");
		i--;
	}
	// o(n)

}

private static void btu(int n) {
	for(int i=1;i<=n;i++)  
	{
		if(n%i==0)        
			System.out.println(i);
	}
}
}
