public class Node<E>{
    private E data;
    private Node<E> above;//what is ontop of this
    private Node<E> next;//what is below this

    public Node(){
	data=null;
	above=null;
	next=null;
    }

    public Node(E input){
	data=input;
	above=null;
	next=null;
    }
    
    public E getData(){
	return data;
    }

    public void setData(E input){
	data=input;
    }

    public Node<E> getAbove(){
	return above;
    }

    public void setAbove(Node<E> input){
	above=input;
    }

    public Node<E> getNext(){
	return next;
    }

    public void setNext(Node<E> input){
	next=input;
    }
}
