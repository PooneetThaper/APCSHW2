public class myQueue<E> implements frontier<E>{

    private Node<E> first,base;

    public myQueue(){
	base=new Node();
    }

    public void enqueue(E data){
	Node<E> n= new Node(data);
	if (first==null){
	    n.setNext(base);
	    base.setBefore(n);
	    first=n;
	}else{
	    Node<E> last=base.getBefore();
	    n.setNext(base);
	    last.setNext(n);
	    base.setBefore(n);
	    n.setBefore(last);
	    last=n;
	}
    }

    public E dequeue(){
	E retval=first.getData();
	Node<E> temp= first.getNext();
	temp.setBefore(null);
	first.setNext(null);
	if(temp!=base) first=temp;
	return retval;
    }

    public boolean empty(){
	return base.getBefore()==null;
    }

    public E head(){
	return first.getData();
    }

    public static void main(String[] args){
	myQueue f=new myQueue();
	for(int i=0;i<10;i++){
	    int[] a={i,i+1};
	    f.enqueue(a);
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
