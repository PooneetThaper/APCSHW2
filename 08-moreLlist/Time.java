public class Time{
    private ArrayList<int> a;

    public Time(int len){
	a= new ArrayList<int>(len);
	for (int i=0;i<len;i++){
	    a.set(i,(int)Math.ceil(Math.random()*10));
	}
    }

    public int lSum(){
	int s=0;
    }
}
