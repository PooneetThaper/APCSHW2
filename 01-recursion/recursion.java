public class recursion{

    //Factorial (n!)
    public int fact(int n){
	if (n==0) return 1;
	else return n*(fact(n-1));
    }

    //returns nth fibonacci number
    public int fib(int n){
	if (n==1 || n==2) return 1;
	else return fib(n-1) + fib(n-2);
    }

    //returns the length of string s
    public int len(String s){
	if (s.equals("")) return 0;
	else return 1+ len(s.substring(1));
    }

    //counts the number of times char c appears in String s
    public int count (String s, char c){
	if (s.length()==0) return 0;
	else{
	   if (s.charAt(0)==(c)) return 1+count(s.substring(1),c);
	   else return count(s.substring(1),c);
	}
    }

    //Coding Bat Problems

    public int bunnyEars2(int bunnies) {
	if (bunnies>0){
	    if (bunnies%2==0) return 3 + bunnyEars2(bunnies-1);
	    if (bunnies%2==1) return 2 + bunnyEars2(bunnies-1);
	}
	return 0;
    }

    public int strCount(String str, String sub) {
	if(str.length() >= sub.length() && sub.length() > 0){
	    if (str.substring(0,sub.length()).equals(sub)) 
		return 1 + strCount(str.substring(sub.length()),sub);
	    else return strCount(str.substring(1),sub);
	}
	else return 0;
    }

    public int sumDigits(int n) {
	if (n>0){
	    return (n%10) + sumDigits(n/10);
	}
	else return 0;
    }

    public String allStar(String str) {
	if (str.length()>=2){
	    return str.substring(0,1) + "*" + allStar(str.substring(1));
	}
	if (str.length()==1) return str;
	return "";
    }
}
