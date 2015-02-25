public class Merging{
    
    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
	ArrayList<Integer> c= new ArrayList<Integer>();
	while (a.size()>0 && b.size()>0){
	    if (a.get(0) < b.get(0)){
		c.add(a.remove(0));
	    }
	    else {
		c.add(b.remove(0));
	    }
	}
	if (a.size()>0){
	    for (int i=0;i<a.size();i++){
		c.add(a.remove(i));
	    }
	}
	else if (b.size()>0){
	    for (int i=0;i<b.size();i++){
		c.add(b.remove(i));
	    }
	}
	return c;
    }

    public static void main(String[] args){
	Merging m = new Merging();
	ArrayList<Integer> b=new ArrayList<Integer>();
	ArrayList<Integer> a=new ArrayList<Integer>();
	for (int i=0; i<10; i++){
	    a.add(Math.ceil(Math.random()*100));
	    b.add(Math.ceil(Math.random()*100));
	}
	m.merge(a,b);
    }

}
