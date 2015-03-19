public class PiggyBackingPointers extends LList{
    private Node l=new Node(-1);
    private int len;
    //alternate remove
    public boolean remove(int n){
	Node T=l.getNext();
	Node T2=l;
	while (T!=null){
	    if(T.getData()==n){
		T2.setNext(T.getNext());
		return true;
	    }
	}
	return false;
    }
}
