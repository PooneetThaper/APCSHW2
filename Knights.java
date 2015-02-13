public class Knights{
    public int[][] places;
    public int next;
    public int numX;
    public int numY;
    
    public Knights(int x, int y){
	numX=x;
	numY=y;
	next=0;
	places= new int[numX][numX];
	for(int i=0; i<numX; i++){
	    for(int j=0; j<numY; j++){
		places[i][j]=0;
	    }
	}
	toString();
	/*for(int i=0; i<numX; i++){
	    for(int j=0; j<numy-1; j++){
		System.out.printf("%2d",places[i][j]);
	    }
	    System.out.printf("%2d\n",places[i][5]);
	    }*/
    }

    public void solve(int x, int y){
	if (places[x][y]=0){
	    places[x][y]=next;
	    next++;
	}
    }
    
    public void toString(){
	String s = "[2J\n";
	for (int y=0;y<maxY;y++)
	    {
		for (int x=0;x<maxX;x++)
		    s = s +places[x][y];
		s=s+"\n";
	    }
    }

    public static void main(String args[]){
	Knights k= new Knights();
    }
}
