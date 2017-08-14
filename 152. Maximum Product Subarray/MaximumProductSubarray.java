public class MaximumProductSubarray{
	public int maxProduct1(int[] nums){
		int max=nums[0];
		int tempMax=nums[0];
		int tempMin=nums[0];
		for(int i=1;i<nums.length;i++){
			if(nums[i]<0){
				int temp=tempMin;
				tempMin=tempMax;
				tempMax=temp;
			}
			tempMax=Math.max(nums[i],tempMax*nums[i]);
			tempMin=Math.min(nums[i],tempMin*nums[i]);
			max=Math.max(max,tempMax);
		}
		return max;
	}



	public int maxProduct1(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
        	int temp=1;
        	for(int j=i;j<nums.length;j++){
        		temp*=nums[j];
        		if(max<temp)
        			max=temp;
        	}
        }
        /*for(int i=1;i<nums.length;i++){
        	nums[i]*=nums[i-1];
        }
        for(int i=0;i<nums.length;i++){
        	for(int j=i;j<nums.length;j++){
        		if(max<nums[j])
        			max=nums[j];
        	}
        	for(int j=i+1;j<nums.length;j++){
        		nums[j]/=nums[i];
        	}
        }*/
        return max;
    }
}