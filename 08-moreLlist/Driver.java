public class Driver{
    public static void main(String[] args) {
	LList l = new LList();
	for (int i=8;i>=0;i--){
	    l.add(""+i);
	}
	System.out.println(l);
	System.out.println(l.get(6));
	System.out.println(l.get(9));
	l.add(3,"banana");
	System.out.println(l);
	l.remove(2);
	System.out.println(l);
    }
}
