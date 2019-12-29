//Class for each hole
public class Hole {
    //Each hole has an instance variable called PebNum - the number of pebbles in a given hole.
    private int PebNum;
    public Hole(int PebNum){
        this.PebNum  = PebNum;
    }

    //A method to get the number of pebbles in a hole.
    public int getPebNum(){
        return PebNum;
    }


//We will create a method to draw the holes and the pebbles in the hole. This method will take in the particular player,
//the index of the hole, and the number of pebbles to draw.

public void drawHole(int playerNum,int i,int pebNum) {
    if (playerNum < 1 || playerNum > 2 || i < 0 || i > 5) {
        System.err.println("Please input valid index and PlayerNumber Next Time. Start over");
    }
    else {
            if (playerNum == 1) {
                StdDraw.setPenColor(3,4,6);
                StdDraw.filledRectangle(0.95-(0.875 - 0.15 * i), 0.425, 0.075, 0.075);
                StdDraw.setPenColor(34,56,78);
                StdDraw.filledRectangle(0.95-(0.875 - 0.15 * i),0.425,0.065,0.065);
                for(int j =0; j < pebNum;j++){
                    double centralXPos = 0.95 - ((0.82625 - (0.15 * i)) + Math.random()*0.0975);
                    double centralYPos = 0.37625 + Math.random()*0.0975;

                    StdDraw.setPenColor(165,42,42);
                    StdDraw.filledCircle(centralXPos,centralYPos,0.01625);
                    //StdDraw.circle(centralXPos,centralYPos,0.01625);
                    //Set Sound.
                    double [] sound = new double[4410];
                    int SAMPLING_RATE = 44100;
                    int n = sound.length;
                    int hz = pebNum * 20 + 20 ;
                    for (int k = 0; k < n; k++) {
                        sound[i] = Math.sin((2 * Math.PI * k * hz) / SAMPLING_RATE);
                    }
                    StdAudio.play(sound);


                }

            } else if (playerNum == 2) {
                StdDraw.setPenColor(3,4,6);
                StdDraw.filledRectangle(0.95 - (0.125 + 0.15 * i), 0.575, 0.075, 0.075);
                StdDraw.setPenColor(34,56,78);
                StdDraw.filledRectangle(0.95 - (0.125 + 0.15 * i),0.575,0.065,0.065);
                for(int j =0;j < pebNum; j++){
                    double centralXPos = 0.95 - ((0.07625 + 0.15*i) + Math.random()*0.0975);
                    double centralYPos = 0.52625 + Math.random()*0.0975;
                    StdDraw.setPenColor(144,116,88);
                    StdDraw.filledCircle(centralXPos,centralYPos,0.01625);
                    //Set Sound.
                    double [] sound = new double[4410];
                    int SAMPLING_RATE = 44100;
                    int n = sound.length;
                    int hz = pebNum * 20 + 20 ;
                    for (int k = 0; k < n; k++) {
                        sound[i] = Math.sin((2 * Math.PI * k * hz) / SAMPLING_RATE);
                    }
                    StdAudio.play(sound);
                    }


            }
         return;
        }
    }public void drawOtherHole(int playerNum,int i,int pebNum) {
        if (playerNum < 1 || playerNum > 2 || i < 0 || i > 5) {
            System.err.println("Please input valid index and PlayerNumber");
            System.exit(1);
        }
        else {
            if (playerNum == 1) {
                StdDraw.rectangle(0.125 + 0.15 * i, 0.425, 0.075, 0.075);
                StdDraw.rectangle(0.125 + 0.15 * i,0.425,0.065,0.065);
                for(int j =0; j < pebNum;j++){
                    double centralXPos = 0.07625 + 0.15*i + Math.random()*0.0975;
                    double centralYPos = 0.37625 + Math.random()*0.0975;
                    StdDraw.circle(centralXPos,centralYPos,0.01625);
                }

            } else if (playerNum == 2) {
                StdDraw.rectangle(0.875 - 0.15 * i, 0.575, 0.075, 0.075);
                StdDraw.rectangle(0.875 - 0.15 * i,0.575,0.065,0.065);
                for(int j =0;j < pebNum; j++){
                    double centralXPos = (0.82625 - (0.15 * i)) + Math.random()*0.0975;
                    double centralYPos = 0.52625 + Math.random()*0.0975;
                    StdDraw.circle(centralXPos,centralYPos,0.01625);
                }


            }
            return;
        }
    }

}

