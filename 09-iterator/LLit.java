import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
		private Node<E> t,t1,t2;
		public LLit(Node<E> n){
				t=n;
				t1=null;
				t2=null;
		}

		public boolean hasNext(){
				return t!=null;
		}

		public E next(){
				E retval = t.getData();
				if(t1!=null) t2=t1;
				t1=t;
				t=t.getNext();
				return retval;
		}

		public void remove(){
				if(t2==null){
						t1=null;
				}else{
						t1=t2;
		    		t1.setNext(t);
				}
		}

}
