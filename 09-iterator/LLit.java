import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
		private Node<E> t;
		private Node<E> t1;
		public LLit(Node<E> n){
				t=n;
				
		}

		public boolean hasNext(){
				return t!=null;
		}

		public E next(){
				E retval = t.getData();
				t1=t;
				t=t.getNext();
				return retval;
		}

		public void remove(){
		    t1.setNext(t.getNext());
		    t=t1.getNext();
		}
}

