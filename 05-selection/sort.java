public class sort{

    private int[] a= {7,5,8,4,1,9,6,2,3,0};

    public sort(){
	//a= new int[10];
    }
    
    public int[] pivot(){
	int[] b= new int[a.length];
	int pivot= (int)Math.floor(Math.random()*10);
	int lowIndex=0;
	int highIndex=a.length-1;

	System.out.println("pivot: "+pivot);
	
	int i=0;
	while(lowIndex!=highIndex){
	    if (a[i]<pivot){
		b[lowIndex]=a[i];
		lowIndex++;
	    }
	    if (a[i]>pivot){
		b[highIndex]=a[i];
		highIndex--;
	    }
	    i++;
	}
	b[lowIndex]=pivot;

	return b;
    }

    public String mytoString(int[] a){
	String s="";
	for(int i=0;i<a.length;i++){
	    s=s+a[i]+", ";
	}
	return s;
    }

    public static void main(String[] args){
	sort s = new sort();
	System.out.println(s.mytoString(s.a));
	System.out.println(s.mytoString(s.pivot()));
    }
    
}
