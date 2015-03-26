public class Driver{
    public static void main(String[] args){
	myQueue<Integer> m=new myQueue<Integer>();

	System.out.println("Empty: "+m.empty());

	for(int i=0;i<=8;i++){
	    m.enqueue(i);
	}

	System.out.println("//Added numbers from 0 to 8");

	System.out.println("Empty: "+m.empty());
  System.out.println("Head: "+m.head());

	while(!m.empty()){
	    System.out.print(m.dequeue()+", ");
	}
	System.out.print("\n");

	System.out.println("Empty: "+m.empty());
    }
}
