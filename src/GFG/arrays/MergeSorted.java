package chap10;

import java.util.Arrays;


public class MergeSorted {

	public static void main(String[] args) {
		int[] a= new int[10] ;
		a[0]= 1;
		a[1]= 5;
		int[] b= new int[5];
		b[0]=2;
		System.out.print(Arrays.toString(merge(a, b)));
	}
	
	static int[] merge(int a[],int b[])
	{
		int m =3;
		int n = b.length;
		int i=1,j=0;
		while(i>=0 && j>=0)
		{
			if(a[i]>=b[j])
			{
				swap(a,a,--m,i--);//a[--m] = a[i--];
			}else {
				swap(a,b,--m,j--);//a[--m] = b[j--];
			}
			
		}
		while(j>=0 &&m>=0)
		{
			swap(a,b,--m,j--);//a[--m]=b[j--];
		}
		
		while(i>=0 &&m>=0)
		{
			swap(a,a,--m,i--);//a[--m]=a[i--];
		}
		
		System.out.print(m+"  "+n);
		
		return a;
	}
	static void swap(int a[],int[] b, int j, int k)
	{
		int t= a[j];
		a[j] =b[k];
		b[k]= t;
	}

}
