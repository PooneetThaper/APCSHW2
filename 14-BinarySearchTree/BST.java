public class BST{
    private Node r;
    
    public BST(){
	r=new Node(5);
    }

    public void insert(Node t, int i){
	Node temp1=t;
	Node temp2=t;
	//assumes that root is not null
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
		temp2=new Node(i);
		temp1.setleftChild(temp2);
	    }
	    if(i>temp1.getdata()){
		temp2=new Node(i);
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

    public static void main(String[] args){
	BST a=new BST();
	a.insert(a.r,4);
	a.insert(a.r,6);
	System.out.println(a.search(a.r,4));
    }
}
