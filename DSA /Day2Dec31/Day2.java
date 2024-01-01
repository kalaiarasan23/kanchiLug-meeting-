package day2Dec31;

public class Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=123000,rev=0;
		
		// 34531
		//13500
		System.out.println((int)(Math.log10(32)/Math.log10(2)));
		
		// res = 131
		
//		countOfDigit(n);
//		sumOfDigit(n);
//		reverserDigit(n);
//		int rev =reverserDigit(n);
//		System.out.println("reverse "+rev);
//		if(rev==n)
//			System.out.println("palandrome ");
//		else
//			System.out.println("not palandrome ");
		
		int remove = 3;
		
//		removeDigit(n, remove);
//		forwardTraverse(n,remove);
		
		
		
		
	}

	private static void forwardTraverse(int n, int remove) {
		int forward=0, ones=1;
		while(n!=0)
		{
			int rem = n%10;
			if(remove != rem) {
				forward = forward + ones*rem;
				ones = ones * 10;
			}
			n =n/10; 
		}
		System.out.println(forward);
	}

	private static void removeDigit(int n, int remove) {
		int rev=0;
		while(n!=0)
		{
			int rem = n%10;
			if(remove!=rem)
				rev = rev*10 +rem;
			n =n/10; 
		}
		
		System.out.println(rev);
		System.out.println(reverserDigit(rev));
//		return rev;
		
	}

	private static int reverserDigit(int n) {
		int rev=0;
		while(n!=0)
		{
			int rem = n%10;
			rev = rev*10 +rem;
			n =n/10; 
		}
//		System.out.println(rev);
		return rev;
	}

	private static void sumOfDigit(int n) {
		int sum=0;
		while(n!=0)
		{
			sum = sum + n%10;
			n =n/10; 
			System.out.println(n + " sum ="+sum);
		}
		
		
		System.out.println("sum of digit "+sum);
	}

	private static void countOfDigit(int n) {
		int count=0;
		while(n!=0)
		{
			count++;
			n =n/10; 
			System.out.println(n);
		}
		System.out.println("count of a number "+count);
	}

	

}
