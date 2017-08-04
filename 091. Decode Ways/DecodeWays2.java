public class DecodeWays2{
    private int[] youhua;
	public int numDecodings(String s) {
        youhua=new int[s.length()+1];
        for(int i=0;i<s.length()+1;i++)
            youhua[i]=-1;
		int count=0;
		if(s.startsWith("0"))
			return 0;
        char[] charArr=s.toCharArray();
		for(int i=1;i<charArr.length;i++){
			if(charArr[i]=='0'&&(charArr[i-1]!='1'&&charArr[i-1]!='2'))
				return 0;
		}
		count=decoding(charArr,0,count);
        return count;
    }
    private int decoding(char[] charArr,int index,int count){
        if(youhua[charArr.length-index]!=-1){
            return count+youhua[charArr.length-index];
        }
        int record=count;
    	if(index>=charArr.length&&charArr.length!=0){
    		return ++count;
    	}else if(charArr.length==0){
    		return count;
    	}
    	if(index==charArr.length-1&&charArr[index]=='0')
    		return count;
    	for(int i=index;i<charArr.length-1;i++){
    		int code=stringToInteger(charArr[i],charArr[i+1]);
    		if(code>10&&code<=26&&code!=20){
    			count=decoding(charArr,i+2,count);
    		}else if(code==10||code==20){
    			i++;
    		}
    	}
        ++count;
        youhua[charArr.length-index]=count-record;
    	return count;
    }
	
	/**
	*将两个字符组合成数字
	*ch1在十位
	*ch2在个位
	*/
	private int stringToInteger(char ch1,char ch2){
		return Integer.parseInt(""+ch1+ch2);
	}
}