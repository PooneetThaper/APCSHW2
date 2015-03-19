import java.io.*;
import java.util.*;

public class Time{
    private ArrayList<Integer> a;
    private LList l;
    private LinkedList<Integer> j;

    public Time(int len){
	a=new ArrayList<Integer>(len);
	l=new LList();
	j=new LinkedList<Integer>();
	for (int i=0;i<len;i++){
	    int k=(int)Math.ceil(Math.random()*10);
	    a.add(k);
	    l.add(k);
	    j.add(k);
	}
    }

    public void Tester(){
	int sum;

	//ArrayList
	sum=0;
	long aStart=System.currentTimeMillis();
	for (int i=0;i<a.size(); i++){
	    sum = sum + a.get(i);
	}
	long aElapsed=System.currentTimeMillis()-aStart;
	System.out.println("ArrayList: "+aElapsed);

	//Our LinkedList
	sum=0;
	long lStart=System.currentTimeMillis();
	for (int i=0;i<l.size(); i++){
	    sum = sum + l.get(i);
	}
	long lElapsed=System.currentTimeMillis()-lStart;
	System.out.println("LList: "+lElapsed);
	
	//java LinkedList
	sum=0;
	long jStart=System.currentTimeMillis();
	for (int i=0;i<j.size(); i++){
	    sum = sum + j.get(i);
	}
	long jElapsed=System.currentTimeMillis()-jStart;
	System.out.println("javaLinkedList: "+jElapsed);	
    }

    public static void main(String[] args){
	Time t= new Time(50000);
	t.Tester();
    }
    
}
