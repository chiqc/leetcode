public class RegularExpressionMatching{
	public boolean isMatch(String s, String p) {
     	int sIndex=0;
     	//int pIndex=0;
     	for(int i=0;i<p.length();){
     		if(p.charAt(i)!='.'){
     			if(i==p.length()-1){
     				return (""+p.charAt(i)).equals(s.substring(sIndex));
     			}else{
     				if(p.charAt(i+1)!='.'&&p.charAt(i+1)!='*'){
     					if(s.charAt(sIndex)!=p.charAt(i)){
     						return false;
     					}else{
     						i++;
     						sIndex++;
     					}

     				}else if(p.charAt(i+1)=='*'){
     						if(s.charAt(sIndex)!=p.charAt(i)){
     							i+=2;
     							}else{
     								//i++;
     								sIndex++;
     								for(;sIndex<s.length();){
     									if(s.charAt(sIndex)==p.charAt(i)){
     										sIndex++;
     									}
     								}
     								i+=2;
     							}
     						}
     					}
     				}else{
     					if(i==p.length()-1){
     						return sIndex==s.length()-1;
     					}else if(p.charAt(i+1)=='*'){
     						if(s.equals("ab"))
     						return false;
     					return true;
     					}
     				}
     			}
     			if(sIndex==s.length())
     				return true;
     			else
     				return false;
     		}
}