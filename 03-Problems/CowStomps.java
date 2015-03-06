public class CowStomps{

    private int[][] pasture= {{28,25,20,32,34,36},
			      {27,25,20,20,30,34},
			      {24,20,20,20,20,30},
			      {20,20,14,14,20,20}};
    private int pastureX;
    private int pastureY;

    /*
    public CowStomps(){
	CowStomps(6,4);
    }
    */

    public CowStomps(int x,int y){
	pastureX=x;
	pastureY=y;
    }

    public void stomp(int R, int C, int stomps){
	int max=0;
	for (int i=R-1;i<R+2;i++){
	    for (int j=C-1;j<C+2;j++){
		if (pasture[i][j]>max) max=pasture[i][j];
	    }
	}

	max-= stomps;
	
	for (int i=R-1;i<R+2;i++){
	    for (int j=C-1;j<C+2;j++){
		if (pasture[i][j]>max){
		    pasture[i][j]=max;
		}
	    }
	}
    }

    public int TDepth(int Elev){
	int TDepth=0;
	for (int r=0;r<pasture.length;r++){
	    for (int c=0;c<pasture[0].length;c++){
		if (pasture[r][c]>Elev) pasture[r][c]=0;
		else{
		    int a= Elev-pasture[r][c];
		    pasture[r][c]=a;
		    TDepth += a;
		}
	    }
	}
	return TDepth;
    }

    public int volume(int Elev){
	return TDepth(Elev)*72*72;
    }

    public String toString(){
	String s="";
	for (int r=0;r<pasture.length;r++){
	    for (int c=0;c<pasture[0].length;c++){
		s=s+pasture[r][c]+" ";
	    }
	    s=s+"\n";
	}
	return s;
    }

    public static void main(String[] args){
	CowStomps c= new CowStomps(6,4);
	System.out.println(c);
	c.stomp(1,4,4);
	System.out.println(c);
	c.stomp(1,1,10);
	System.out.println(c);
	System.out.println(c.volume(22));
    }
}
