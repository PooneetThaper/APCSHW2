public class BST{
    private Node r;
    
    public BST(){
    }

    public void insert(Node t, int i){
	Node n= new Node(i);
	Node temp1=t;
	Node temp2=t;
	if (r==null){
	    r=n;
	    return;
	}
        while(temp2!=null){
	    temp1=temp2;
	    if (i<temp1.getdata())
		temp2=temp1.getleftChild();
	    else if(i>temp1.getdata())
		temp2=temp1.getrightChild();
	    else break;//i is already there
	}
	if (temp2==null){
	    if (i<temp1.getdata()){
		temp2=n;
		temp1.setleftChild(temp2);
	    }
	    else if(i>temp1.getdata()){
		temp2=n;
		temp1.setrightChild(temp2);
	    }
	}
    }

    public Node search(Node t, int i){
	Node temp1=t;
	Node temp2=t;
	while(temp2!=null){
	    temp1=temp2;
	    if(i<temp1.getdata()){
		temp2=temp1.getleftChild();
	    }else if(i>temp1.getdata()){
		temp2=temp1.getrightChild();
	    }else{
		return temp1;
	    }
	}
	return null;
    }

    public String down(Node n){
	if (n==null) return "";
	String s=n.getdata()+", ";
	s=s+down(n.getleftChild());
	s=s+down(n.getrightChild());
	return s;
    }

    public String ascending(Node n){
	if (n==null) return "";
	String s="";
	s=s+ascending(n.getleftChild());
	s=s+n.getdata()+", ";
	s=s+ascending(n.getrightChild());
	return s;
    }

    public String toString(){
	return ascending(r);
    }

    public void remove(Node t, int i){
        Node temp1=t;
	Node temp2=t;
	while(temp2!=null){
	    temp1=temp2;
	    if(i<temp1.getdata()){
		temp2=temp1.getleftChild();
		if(temp2.getdata()==i) 
		    break;
	    }else if(i>temp1.getdata()){
		temp2=temp1.getrightChild();
		if(temp2.getdata()==i) 
		    break;
	    }
	}
	if(temp2!=null&&temp2.getdata()==i){
	    if (temp2.getleftChild()==null||
		temp2.getrightChild()==null){
		if(temp1.getdata()>temp2.getdata()){
		    
		}
		    
    }

    public static void main(String[] args){
	BST a=new BST();/*
	a.insert(a.r,5);
	a.insert(a.r,4);
	a.insert(a.r,6);*/
	for (int i=0;i<10;i++){
	    a.insert(a.r,(int)Math.ceil(Math.random()*10));
	}
	System.out.println(a.search(a.r,4));

	System.out.println(a.toString());
    }
}
