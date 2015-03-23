public class Node<E>{
    private E data;
    private Node<E> above;
    private Node<E> below;

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

    public Node<E> getBelow(){
	return below;
    }

    public void setBelow(Node<E> input){
	below=input;
    }
}
