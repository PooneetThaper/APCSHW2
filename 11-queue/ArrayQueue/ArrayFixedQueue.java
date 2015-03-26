public class ArrayFixed{
    public E[] queue;
    public int lastOpen;

    public ArrayQueue<E>(){
	queue=new E[20];
	lastOpen=0;
    }

    public void enqueue(E data){
	if (lastOpen<queue.length){
	    queue[lastOpen]=data;
	    lastOpen++;
	}else{
	    System.out.println("Sorry, queue is full");
	}

    }

    public E dequeue(){
	if (!empty()){
	    E retval=queue[0];
	    for(int i=1;i<queue.length;i++){
		queue[i-1]=queue[i];
	    }
	    queue[queue.length-1]=null;
	    lastOpen--;
	    return retval;
	}
	return null;
    }

    public boolean empty(){
	return lastOpen==0;
    }

    public E head(){
	return queue[0];
    }
}
