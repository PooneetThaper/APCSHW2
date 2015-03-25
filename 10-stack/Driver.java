public class Driver{
    public static void main(String[] args){
	myStack<Integer> m=new myStack<Integer>();

	System.out.println("Empty: "+m.empty());
       
	for(int i=8;i>=0;i--){
	    m.push(i);
	}

	System.out.println(m.top());

	System.out.println("Empty: "+m.empty());
	
	while(!m.empty()){
	    System.out.print(m.pop()+", ");
	}

	System.out.println("Empty: "+m.empty());
    }
}
