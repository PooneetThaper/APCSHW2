public class myQueue<E> implements frontier<E>{

    private Node<E> first,last;

    public myQueue(){
    }

    public void enqueue(E data){
	int[][] input=(int[][])data;
	Node<E> n= new Node(data);
	if (first==null){
	    first=n;
	    last=n;
	}else{
	    int[][] firstData=(int[][])first.getData();
	    int[][] lastData=(int[][])last.getData();
	    if(input[2][0]<firstData[2][0]){
		n.setNext(first);
		first=n;
	    }else if(input[2][0]<lastData[2][0]){
		Node temp=first;
		Node temp1=first.getNext();
		while (temp1.getNext()!=null){
		    int[][] data1=(int[][]) temp1.getData();
		    if (input[2][0]<data1[2][0]){
			n.setNext(temp1);
			temp.setNext(n);
		    }
		    temp=temp.getNext();
		    temp1=temp1.getNext();
		}
	    }else{
		last.setNext(n);
		last=n;
	    }
	}
    }

    public E dequeue(){
	E retval=first.getData();
	Node<E> temp= first.getNext();
	first.setNext(null);
	first=temp;
	return retval;
    }

    public boolean empty(){
	return first==null;
    }

    public E head(){
	return first.getData();
    }

    public static void main(String[] args){
	myQueue f=new myQueue();
	for(int i=0;i<10;i++){
	    f.enqueue(i);
	}
	System.out.println(f.head());
	System.out.println(f.empty());
	while(!f.empty()){
	    System.out.print(f.dequeue()+", ");
	}
	System.out.println("");
	System.out.println(f.empty());
    }
}
