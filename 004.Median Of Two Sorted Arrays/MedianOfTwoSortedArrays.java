package practice004;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] num1={3};
		int[] num2={1,2};
		System.out.println(findMedianSortedArrays(num1,num2));
		
	}
	public static double findMedianSortedArrays(int[] num1, int[] num2) {
		int length=num1.length+num2.length;
		int[] arr=new int[length];
		int flag1=0; //0
		int flag2=0;//0 1
		int flag=0;
		while(flag1<num1.length&&flag2<num2.length){
			if(num1[flag1]<=num2[flag2]){
				arr[flag]=num1[flag1];
				flag++;
				flag1++;
			}else{
				arr[flag]=num2[flag2];
				flag++;
				flag2++;
			}
		}
		if(flag1<num1.length){
			for(int i=flag1;i<num1.length;i++)
				arr[flag++]=num1[i];
			
		}else{
			for(int i=flag2;i<num2.length;i++)
				arr[flag++]=num2[i];
		}//0 1 2 3 4 5
		if(length%2==1)
			return arr[(length-1)/2];
		else
			return (arr[(length/2)]+arr[(length/2-1)])*1.0/2;      
    }
}
