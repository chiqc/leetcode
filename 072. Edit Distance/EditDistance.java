public class EditDistance{
	public int minDistance(String word1, String word2) {
		int m=word1.length();
		int n=word2.length();
        int[][] arr=new int[m+1][n+1];
        arr[0][0]=0;
        for(int i=1;i<=m;i++)
        	arr[i][0]=i;
        for(int i=1;i<=n;i++)
        	arr[0][i]=i;
        for(int i=1;i<=m;i++)
        	for(int j=1;j<=n;j++){
        		if(word1.charAt(i-1)==word2.charAt(j-1))
        			arr[i][j]=arr[i-1][j-1];
        		else
        			arr[i][j]=Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]))
        	}
        return arr[m][n];
    }
}