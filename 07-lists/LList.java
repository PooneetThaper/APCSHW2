public class LList{
    private Node l=null;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
    }
		
    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }
    public String find(int n){
	int count=0;
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    if (count==n) return tmp.getData();
	    else count++;
	    
	}
	return null;
    }

    public void insert(int n, String s){
	if (n==0){
	    add(s);
	}else{
	    int count=0;
	    Node in = new Node(s);
	    for (Node tmp=l; tmp!=null;tmp=tmp.getNext()){
		if (count==n-1){
		    in.setNext(tmp.getNext());
		    tmp.setNext(in);
		}
		count++;
	    }
	}
    }
}
