public class Driver{
    public static void main(String[] args) {
	LList l = new LList();
	for (int i=8;i>=0;i--){
	    l.add(""+i);
	}
	System.out.println(l);
	System.out.println(l.find(6));
	System.out.println(l.find(9));
	l.insert(3,"banana");
	System.out.println(l);
    }
}
