public class UniqueBinarySearchTrees{
    public int numTrees(int n){
        //0->1
        //1->1
        //2->2  0和1 1和0
        //3->5  0和2 1和1 2和0
        //0和3 1和2 2和1 3和0
        if(n==1)
            return 1;
        int[] arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            int sum=0;
            for(int j=0;j<i;j++){
                sum=sum+arr[j]*arr[i-1-j];
            }
            arr[i]=sum;
        }
        return arr[n];
    }
}