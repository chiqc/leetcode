public class DecodeWays{
	public int numDecodings(String s) {
		int count=0;
		if(s.startsWith("0"))
			return 0;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)=='0'&&(s.charAt(i-1)!='1'&&s.charAt(i-1)!='2'))
				return 0;
		}
		count=decoding(s,0,count);
        return count;
    }
    private int decoding(String s,int index,int count){
    	if(index>=s.length()&&s.length()!=0){
    		return ++count;
    	}else if(s.length()==0){
    		return count;
    	}
    	if(index==s.length()-1&&s.charAt(index)=='0')
    		return count;
    	for(int i=index;i<s.length()-1;i++){
    		int code=stringToInteger(s.charAt(i),s.charAt(i+1));
    		if(code>10&&code<=26&&code!=20){
    			count=decoding(s,i+2,count);
    		}else if(code==10||code==20){
    			i++;
    		}
    	}
    	return ++count;
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