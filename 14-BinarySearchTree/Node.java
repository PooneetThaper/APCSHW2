public class Node<E>{
    private Node rightChild;
    private Node leftChild;
    private E data;
    
    public Node<E>(){
	rightChild=null;
	leftChild=null;
    }

    public Node(E input){
	data=input;
	Node();
    }

    public void setrightChild(Node n){
	rightChild=n;
    }

    public Node getrightChild(){
	return rightChild;
    }

    public void setleftChild(Node n){
	leftChild=n;
    }

    public Node getleftChild(){
	return leftChild;
    }

    public void setdata(E data){
	data=this.data;
    }

    public E getdata(){
	return data;
    }
}
