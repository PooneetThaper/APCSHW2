public class Node{
    private Node rightChild;
    private Node leftChild;
    private int data;

    public Node(int input){
	data=input;
	rightChild=null;
	leftChild=null;
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

    public void setdata(int data){
	data=this.data;
    }

    public int getdata(){
	return data;
    }
}
