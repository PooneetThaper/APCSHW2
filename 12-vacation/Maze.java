import java.io.*;
import java.util.*;

public class Maze
{
    private char[][] board;
    private int maxX;
    private int maxY;

    private char path='#';
    private char wall=' ';
    private char start='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;
    private frontier f;

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public Maze()
    {
	//breadth
	//f=new myQueue();

	//depth
	f=new myStack();

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
	int[][] start= {{x,y},{x,y}};
	f.enqueue(start);
	while(!f.empty()){
	    int[][] dequeued=(int[][])f.dequeue();
	    int[] current=(int[])dequeued[0];
	    if (board[current[0]][current[1]]==exit){
		solved=true;
		break;
	    }else{
		if(board[current[0]][current[1]]!='z')
		    board[current[0]][current[1]]='.';
		System.out.println(this);
		check(current[0]+1,current[1],current);
		check(current[0],current[1]-1,current);
		check(current[0]-1,current[1],current);
		check(current[0],current[1]+1,current);
	    }
	    try{
		//Thread.sleep(100);
	    }catch(Exception e){}
	}
	if (solved){

	}
    }

    public void check(int x, int y, int[] current){
	if (board[x][y]==wall ||
	    board[x][y]==visited||
	    x==maxX-1|| y==maxY-1){
	    return;
	}else{
	    int[] a={x,y};
	    int[][] full={a,current};
	    f.enqueue(full);
	}
    }

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(1,1);
	System.out.println(m);

    }
}
