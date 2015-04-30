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
        Node temp1=new Node(Integer.MIN_VALUE);
	Node temp2=temp1;
	temp1.setrightChild(t);
	Boolean right=false;
	while(temp2!=null){
	    temp1=temp2;
	    if(i<temp1.getdata()){
		temp2=temp1.getleftChild();
		if(temp2.getdata()==i){
		    right=false;
		    break;
		}
	    }else if(i>temp1.getdata()){
		temp2=temp1.getrightChild();
		if(temp2.getdata()==i){
		    right=true;
		    break;
		}
	    }
	}
	if(temp2!=null&&temp2.getdata()==i){
	    if (temp2.getleftChild()==null){
		if(right){
		    temp1.setrightChild(temp2.getrightChild());
		}else{
		    temp1.setleftChild(temp2.getrightChild());
		}
	    } if (temp2.getrightChild()==null){
		if(right){
		    temp1.setrightChild(temp2.getleftChild());
		}else{
		    temp1.setleftChild(temp2.getleftChild());
		}
	    }else{
		Node temp3=temp2.getleftChild();
		while(temp3.getrightChild()!=null){
		    temp3=temp3.getrightChild();
		}
		temp2.setdata(temp3.getdata());
		remove(temp2,temp3.getdata());
	    }
	}
    }

    public static void main(String[] args){
	BST a=new BST();/*
	a.insert(a.r,5);
	a.insert(a.r,4);
	a.insert(a.r,6);*/
	for (int i=0;i<10;i++){
	    a.insert(a.r,i);
	}
	System.out.println(a.search(a.r,4));

	System.out.println(a.toString());
	a.remove(a.r,9);
	System.out.println(a.toString());
    }
}
