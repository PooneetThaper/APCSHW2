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
	    //bug fixing
	    System.out.println(a);
	    System.out.println(b);
	    System.out.println("");
	    //end debugging
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

    public ArrayList<Integer> msort(ArrayList<Integer> L){
	if (L.size()<2) return L;
	else {
	    ArrayList<Integer> a= new ArrayList<Integer>();
	    for(int i=0; i<L.size()/2;i++){
		a.add(L.get(i));
	    }
	    ArrayList<Integer> b= new ArrayList<Integer>();
	    for(int i=L.size()/2; i<L.size();i++){
		b.add(L.get(i));
	    }
	    return merge(msort(a),msort(b));
	}
    }

    public static void main(String[] args){
	Merging m = new Merging();
	ArrayList<Integer> b=new ArrayList<Integer>();
	ArrayList<Integer> a=new ArrayList<Integer>();
	for (int i=0; i<10; i++){
	    a.add((int)Math.ceil(Math.random()*100));
	    b.add((int)Math.ceil(Math.random()*100));
	}
	System.out.println(a.size());
	System.out.println(b.size());
	ArrayList<Integer> c = m.merge(msort(a),msort(b));
	System.out.println(c.size());
	System.out.println(c);
	ArrayList<Integer> d=m.msort(c);
	System.out.println(d);
	System.out.println(d.size());
    }

}
