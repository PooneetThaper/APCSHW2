import java.util.ArrayList;

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
	
	while (a.size()>0){
		c.add(a.remove(0));
	}
        while (b.size()>0){
		c.add(b.remove(0));
	}
	return c;
    }

    public ArrayList<Integer> msort(ArrayList<Integer> L){

	if (L.size()<=1) return L;
	else {
	    int d=L.size()/2;
	    ArrayList<Integer> a= new ArrayList<Integer>();
	    for(int i=0; i<d;i++){
		a.add(L.get(i));
	    }

	    ArrayList<Integer> b= new ArrayList<Integer>();
	    for(int i=d; i<L.size();i++){
		b.add(L.get(i));
	    }

	    return merge(msort(a),msort(b));
	}
    }

    public static void main(String[] args){
	Merging m = new Merging();
	ArrayList<Integer> b=new ArrayList<Integer>();
	ArrayList<Integer> a=new ArrayList<Integer>();
	for (int i=0; i<200000; i++){
	    a.add((int)Math.ceil(Math.random()*100));
	    b.add((int)Math.ceil(Math.random()*100));
	}

	ArrayList<Integer> c = m.merge(m.msort(a),m.msort(b));
	//System.out.println(c);
    }

}
