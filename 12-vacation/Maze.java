import java.io.*;
import java.util.*;

public class Maze
{
    private char[][] board;
    private int maxX;
    private int maxY;

    private char path='#';
    private char wall=' ';
    private char solution='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;

    private frontier f;
    private int[][][] board2;

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public Maze()
    {
	//breadth
	f=new myQueue();

	//depth
	//f=new myStack();

	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
	board2= new int[maxX][maxY][];

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
	int[]open={x,y};
	int[][] start= {open,open};
	board2[x][y]=open;
	f.enqueue(start);
	while(!f.empty()){
	    int[][] dequeued=(int[][])f.dequeue();
	    int[] current=(int[])dequeued[0];
	    if (board[current[0]][current[1]]==exit){
		solved=true;
		retraceSteps(current);
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
    }

    public void check(int x, int y, int[] current){
	if (board[x][y]==wall ||
	    board[x][y]==visited||
	    x==maxX-1|| y==maxY-1){
	    return;
	}else{
	    board2[x][y]=current;
	    int[] a={x,y};
	    int[][] full={a,current};
	    f.enqueue(full);
	}
    }

    public void retraceSteps(int[] current){
	while (current!=board2[current[0]][current[1]]){
	    if (board[current[0]][current[1]]!=exit)
		board[current[0]][current[1]]=solution;
	    current=board2[current[0]][current[1]];
	}
	board[current[0]][current[1]]='O';
    }

    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(1,1);
	System.out.println(m);

    }
}
