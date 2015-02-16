import java.io.*;
import java.util.*;

public class Knights{
    private int[][] places;
    private int next;
    private int numX;
    private int numY;
    private boolean solved=false;
    
    
    public Knights(int x, int y){
	numX=x;
	numY=y;
	next=1;
	places= new int[numX][numX];
	for(int i=0; i<numX; i++){
	    for(int j=0; j<numY; j++){
		places[i][j]=0;
	    }
	}
	printBoard();
	solve(0,0);
    }

    public void solve(int x, int y){
	if (x>=5||x<0||
	    y>=5||y<0||
	    solved||
	    places[x][y]>0){
	    return;
	}
	
	if (next> (numX * numY)){
	    printBoard();
	    solved = true;
	}
	
	places[x][y]=next;
	next++;
	printBoard();
	try{
	    Thread.sleep(1000);
	}catch(Exception e){}
	solve(x-2,y-1);
	solve(x-2,y+1);
	solve(x-1,y+2);
	solve(x+1,y+2);
	solve(x+2,y+1);
	solve(x+2,y-1);
	solve(x+1,y-2);
	solve(x-1,y-2);
    }
    
    public void printBoard(){
	for(int i=0; i<numX; i++){
	    for(int j=0; j<numY-1; j++){
		System.out.printf("%3d",places[i][j]);
	    }
	    System.out.printf("%3d\n",places[i][4]);
	}
	System.out.println("");
    }

    public static void main(String args[]){
	Knights k= new Knights(5,5);
    }
}
