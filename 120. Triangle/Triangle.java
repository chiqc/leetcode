public class Triangle{
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)
        	return triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
        	List<Integer> nowList=triangle.get(i);
        	List<Integer> lastList=triangle.get(i-1);
        	for(int j=0;j<nowList.size();j++){
        		if(j==0)
        			nowList.set(j,lastList.get(0)+nowList.get(0));
        		else if(j==nowList.size()-1)
        			nowList.set(j,lastList.get(j-1)+nowList.get(j));
        		else{
        			int min=Math.min(lastList.get(j-1),lastList.get(j));
        			nowList.set(j,min+nowList.get(j));
        		}
        	}
        }
        List<Integer> list=triangle.get(triangle.size()-1);
        int min=list.get(0);
        for(int i=0;i<list.size();i++){
        	if(min>list.get(i))
                min=list.get(i);
        }
        return min;
    }
}