public class myQueue<E> implements frontier<E>{

    private Node<E> first,last;

    public myQueue(){
    }

    public void enqueue(E data){
	Node<E> n= new Node(data);
	if (first==null){
	    first=n;
	    last=n;
	}else{
	    last.setNext(n);
	    last=n;
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
