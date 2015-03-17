public class LList{
    private Node l=new Node("dummy");
    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	//tmp.setNext(l);
	//l = tmp;
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
    public Node get(int n){
	int count=0;
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    if (count==n+1) return tmp;
	    else count++;
	}
	return null;
    }
    public void add(int n, String s){
	int count=0;
	Node in = new Node(s);
	for (Node tmp=l; tmp!=null;tmp=tmp.getNext()){
	    if (count==n){
		in.setNext(tmp.getNext());
		tmp.setNext(in);
	    }
	    count++;
	}
	
    }
    public void remove(int n){
	int count=0;
	for (Node tmp=l; tmp!=null;tmp=tmp.getNext()){
	    if (count==n){
		tmp.setNext(tmp.getNext().getNext());
	    }
	    count++;
	}
    }
}
