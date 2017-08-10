public class UniquePathsII{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] grid=new int[m][n];
        if(obstacleGrid[0][0]==1)
            grid[0][0]=0;
        else
            grid[0][0]=1;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    grid[i][j]=grid[i][j];
                }else if(i!=0&&j==0){
                    if(obstacleGrid[i][j]!=1){
                        grid[i][j]=grid[i-1][j];
                    }else{
                        grid[i][j]=0;
                    }
                }else if(i==0&&j!=0){
                    if(obstacleGrid[i][j]!=1){
                        grid[i][j]=grid[i][j-1];
                    }else{
                        grid[i][j]=0;
                    }
                }else if(i!=0&&j!=0){
                    if(obstacleGrid[i][j]!=1){
                        grid[i][j]=grid[i-1][j]+grid[i][j-1];
                    }else{
                        grid[i][j]=0;
                    }
                }
            }
            return grid[m-1][n-1];
    }
}