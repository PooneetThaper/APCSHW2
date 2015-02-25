import java.io.*;
import java.util.*;

public class Knights{
    private int[][] places;
    private int next;
    private int numX;
    private int numY;
    private int startX;
    private int startY;
    private boolean solved=false;
    private int[][] moves={{-2,-1},{-2,1},{-1,2},{1,2},
			   {2,1},{2,-1},{1,-2},{-1,-2}};
    private int statesTried=0;
    private int successes=0;

    
    public Knights(int x, int y, int startX, int startY){
	//the numX and numY set the size of the board
	numX=x;
	numY=y;
	//next tells which number is next
	next=1;
	places= new int[numX][numX];
	for(int i=0; i<numX; i++){
	    for(int j=0; j<numY; j++){
		places[i][j]=0;
	    }
	}
	printBoard();
        solve(startX,startY);
    }

    public void solve(int x, int y){
	statesTried++;

	if (x>=numX||x<0||
	    y>=numY||y<0||
	    places[x][y]>0){
	    return;
	}
	

	if (solved){
	    System.out.println("You have solved it");
	    System.exit(0);
	}
	
	//clecks to see if the previous move was legal
	Boolean notStupid=false;
	for (int i=0;i<moves.length;i++){
	    try{
		if (places[x+moves[i][0]][y+moves[i][1]]==next-1){
		    notStupid=true;
		}
	    }catch (ArrayIndexOutOfBoundsException e){}
	}

	
	//if previous move was legal, 
	//it sets current place to next
	//then it makes the next move
	if (notStupid){
	    places[x][y]=next;
	    next++;
	    if (next==25){
		printBoard();
		System.out.println(statesTried);
	        solved = true;
	    }

	    for(int p=0;p<moves.length;p++){
		solve(x+moves[p][0],y+moves[p][1]);
	    }
	    //if none of these moves worked out
	    if (x==startX && y==startY){
		System.out.println("there are no solutions here");
	    }
	    else{
		places[x][y]=0;
		next--;
		return;
	    }
	}
	//if previous move was not legal, it returns to last layer
	else return;
    }
    
    public void printBoard(){
	for(int i=0; i<numX; i++){
	    for(int j=0; j<numY-1; j++){
		//covers all but the last place in a row
		System.out.printf("%3d",places[i][j]);
	    }
	    //the last place in a row is printed with a \n
	    System.out.printf("%3d\n",places[i][numX-1]);
	}
	//skips a line between consecutive boards
	System.out.println("");
    }

}
