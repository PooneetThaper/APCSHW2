import java.io.*;
import java.util.*;

public class Maze
{
    private char[][] board;
    private int maxX;
    private int maxY;
    private frontier f;

    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public Maze()
    {
	f=new myQueue();
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];

	try {

	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext())
		{
		    String line = sc.nextLine();
		    for (int i=0;i<maxX;i++)
			{
			    board[i][j] = line.charAt(i);
			}
		    j++;
		}
	}
	catch (Exception e)
	    {
	    }

    }

    public String toString()
    {
	String s = "[2J\n";

	for (int y=0;y<maxY;y++)
	    {
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	return s;
    }

    /*
      solved - instance variable to indicate we're done

    */
    public void solve(int x, int y){
	//frontier put as instance variable for
	//use by multiple methods
	int[] start= {x,y};
	f.enqueue(start);
	while(!f.empty()){
	    int[] current=(int[])f.dequeue();
	    System.out.println(this);
	    if (board[current[0]][current[1]]==exit){
		solved=true;
		break;
	    }else{
		check(current[0]+1,current[1]);
		check(current[0],current[1]-1);
		check(current[0]-1,current[1]);
		check(current[0],current[1]+1);
	    }
	    board[current[0]][current[1]]='.';
	}
    }

    public void check(int x, int y){
	if (board[x][y]==wall ||
	    board[x][y]==visited){
	    return;
	}else{
	    int[] a={x,y};
	    f.enqueue(a);
	}
    }

    public static void main(String[] args){
	Maze m = new Maze();/*
	System.out.println(m);
	m.solve(1,1);*/
	System.out.println(m);

    }
}
