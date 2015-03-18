public class Node{
    private int data;
    private Node next;
    public Node(int i){
	data = i;
	next = null;
    }
    public void setData(int i){
	data = i;
    }
    public int getData(){
	return data;
    }
    public void setNext(Node n){
	next = n;
    }
    public Node getNext(){
	return next;
    }
    public String toString(){
	return Integer.toString(data);
    }
}
