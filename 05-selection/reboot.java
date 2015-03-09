public class reboot{
    public static int Select(int[] A, int k, int l, int h){
	int pivotIndex = k;
	int pivotPt= A[pivotIndex];
	int HighPt=h;
	int high=h;
	int low=l;
	swap(A, (l+h)/2, high);
	high--;
	while (low<high){
	    if(A[low]<pivotPt){
		low++;
		//move on because its in the right place
	    }else{
		swap(A,low,high);
		//if its not less than pivot;
		//through it to the right side
		high--;
		//move high down
	    }
	}
	
	if (A[low]>pivotPt){
	    swap(A, low, HighPt);
	    pivotIndex=low;
	}else{
	    swap(A, low+1, HighPt);
	    pivotIndex=low+1;
	}
	if(pivotIndex==k){
	    //ie the pivot is the kth low
	    return A[k];
	}else if (pivotIndex>k){
	    //the pivot is greater than the kth low
	    return Select(A, k, l, pivotIndex -1);
	    //look for the kth one in the numbers before the pivot
	}else{
	    //pivot is less than the kth low
	    return Select(A, k, pivotIndex+1, h);
	    //look above the pivot since kth low must be there
	}
    }

    public static void swap(int[] A, int a, int b){
	int temp=A[a];
	A[a]=A[b];
	A[b]=temp;
	//pulled this out because it is used over and over
    }

    public static void main(String[] args){
	int[] Array = {5,4,7,6,1,2,8,9,3,0};
	System.out.println(Select(Array,6,0,9));
	//should give 5
    }
    
}
