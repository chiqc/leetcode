package com.cqc.leetcode.practice003;

public class LongestSubstringWithoutRepeatingCharacters3 {
	public static void main(String[] args) {
		/*//a=97 z=122 A=65 Z=90 26*2=52
		char ch='Z';
		System.out.println((int)ch);*/
		String str="au";
		System.out.println(lengthOfLongestSubstring2(str));
	}
	public static int lengthOfLongestSubstring2(String s) {
		if(s.length()==1){
			return 1;
		}
		int max=0;
		int begin=0;
		int[] record=new int[128];
		for(int i=0;i<128;i++)
			record[i]=0;
		while(begin<s.length()){
			//int index;//0 1 2 3 4 begin=2 i=4
			for(int i=begin;i<s.length();i++){
				if(record[((int)s.charAt(i))]==0){
					record[((int)s.charAt(i))]=1;
					if(i==s.length()-1)
						return max>(i-begin)?max:(i-begin);
				}else{
					if(i-begin>max)
						max=i-begin;
					begin++;
					for(int j=0;j<128;j++)
						record[j]=0;
					break;
				}
			}
		}
        return max;
    }
	public static int lengthOfLongestSubstring(String s) {
		int max=0;
		int begin=0;
		int[] record=new int[52];
		for(int i=0;i<52;i++)
			record[i]=0;
		while(begin<s.length()){
			int index;//0 1 2 3 4 begin=2 i=4
			for(int i=begin;i<s.length();i++){
				if((index=(int)s.charAt(i))<97){
					if(record[index-65]==0)
						record[index-65]=1;
					else{
						if(i-begin>max)
							max=i-begin;
						begin++;
						for(int j=0;j<52;j++)
							record[j]=0;
						break;
					}
				}else{
					if(record[index-71]==0)
						record[index-71]=1;
					else{
						if(i-begin>max)
							max=i-begin;
						begin++;
						for(int j=0;j<52;j++)
							record[j]=0;
						break;
					}
				}
			}
		}
        return max;
    }
}
