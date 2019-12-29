public class Region {
    //An Array of holes
    private Hole [] a;
    private int score;
    //Constructor variable
    Region(int n){
        a = new Hole[n];
    }

    public Hole[] regArr(){
        return a;
    }
    public void addScore(int a){
        score =  score + a;
    }
    public int getScore(){
        return score;
    }
    public void drawEntireRegion(int playerNum){
        for (int k = 0; k < 6; k++){
            a[k].drawHole(playerNum,k,a[k].getPebNum());
        }

    }
    public void drawOtherEntireRegion(int playerNum){
        for (int f = 0; f < 6; f++){
            a[f].drawOtherHole(playerNum,f,a[f].getPebNum());
        }
    }













   /* public void drawRegion(){
        StdDraw.rectangle(0.05,0.3,0.075,0.075);
        StdDraw.rectangle(0.20,0.3,0.075,0.075);
        StdDraw.rectangle(0.35,0.3,0.075,0.075);
        StdDraw.rectangle(0.60,0.3,0.075,0.075);
        StdDraw.rectangle(0.75,0.3,0.075,0.075);
        StdDraw.rectangle(0.90,0.3,0.075,0.075);
    }
    public void drawRegion(int a){
        StdDraw.rectangle(0.05,0.3,0.075,0.075);
        StdDraw.rectangle(0.20,0.3,0.075,0.075);
        StdDraw.rectangle(0.35,0.3,0.075,0.075);
        StdDraw.rectangle(0.60,0.3,0.075,0.075);
        StdDraw.rectangle(0.75,0.3,0.075,0.075);
        StdDraw.rectangle(0.90,0.3,0.075,0.075);

    }*/

    //public String toString(){
   //     return a;
   // }

}
