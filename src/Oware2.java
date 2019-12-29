public class Oware2 {

        public static void main(String[]args){
            //Create two regions for each player
            Region Player1 = new Region(6);
            Region Player2 = new Region(6);

            //Fill each hole in each region with 4 pebbles.

            //Player1 first.
            for(int i = 0; i < Player1.regArr().length;i++){
                Hole a = new Hole(4);
                Player1.regArr()[i] = a;
            }
            //Then player2
            for(int i = 0; i < Player2.regArr().length;i++){
                Hole a = new Hole(4);
                Player2.regArr()[i] = a;
            }

            //How do I distribute the pebbles from a given index, Index ?
            //I need a variable to track which player's turn it is. I will make the variable in such a way that whenever it
            //is odd, it is player 1's turn and anytime it's even, it's player 2's turn.
            int PlayerTracker = Integer.parseInt(args[0]);
            Region x;
            Region y;
            if(PlayerTracker ==1){
                x = Player1;
                y = Player2;
            }
            else{
                x = Player2;
                y = Player1;
            }
            int Index = Integer.parseInt(args[1]);
            //Recursion/ for loop?
            //Try recursion first.
            //Recursion outside main statement
            //Try a for loop next
            //Put the number of pebbles at inputted index into hands
            int pebNumInHands = x.regArr()[Index].getPebNum();
            //Set the selected index to 0.
            Hole tempHole = new Hole(0);
            x.regArr()[Index] = tempHole;





            //Code to distribute pebbles in player1's region
            int ArrayTracker = pebNumInHands;
            int pebLeft = pebNumInHands;
            int i;
            for( i = Index+1; i < Index + ArrayTracker +1   ; i ++){
                int pebNumAtIndexI = x.regArr()[i].getPebNum();
                Hole newHole = new Hole(pebNumAtIndexI+1);
                x.regArr()[i] = newHole;
                //System.out.println(x.regArr()[i].getPebNum());
                Hole oldHole = new Hole(pebNumInHands-1);
                pebNumInHands = oldHole.getPebNum();
                // System.out.println(pebNumInHands);

                if (i == 5) {
                    break;
                }

            }
            if(pebNumInHands ==0){
                Index = i;
                pebNumInHands = x.regArr()[i].getPebNum();
                if(pebNumInHands ==1){
                    //break;
                }
            }

            //Code to distribute pebbles in player2's region after player1.
            //if there are more pebbles left in the hand after distributing to holes in the present region,
            // continue in the next region.

            if(pebLeft > 0) {
                for (int j = 0; j < pebLeft; j++) {
                    int pebNumAtIndexJ = y.regArr()[j].getPebNum();
                    //System.out.println(pebNumAtIndexJ);
                    Hole newHole = new Hole(pebNumAtIndexJ + 1);
                    y.regArr()[j] = newHole;
                    System.out.println(y.regArr()[j].getPebNum());
                    Hole oldHole = new Hole(pebNumInHands - 1);
                    pebNumInHands = oldHole.getPebNum();
                    System.out.println(pebNumInHands);
                    if (j == 5) {
                        //Update the number of pebbles left.
                        pebLeft = oldHole.getPebNum();
                        break;
                    }

                }

            }
            //if there are still more pebbles Left after filling the next region, go to the previous region.
            if(pebLeft > 0){
                for ( i = 0; i < pebLeft; i++) {
                    int pebNumAtIndexI = x.regArr()[i].getPebNum();
                    Hole newHole = new Hole(pebNumAtIndexI + 1);
                    x.regArr()[i] = newHole;
                    Hole oldHole = new Hole(pebNumInHands - 1);
                    pebNumInHands = oldHole.getPebNum();
                    if (i == 5) {
                        //Update the number of pebbles left.
                        pebLeft = oldHole.getPebNum();
                        break;
                    }
                }
            }
        }
            //Per the way the game is, after running all these steps, the number of pebbles in the original hole should have finished.


        //Argument takes in the player region and the index to start from.
   /* public static void Distribute(Region Player, int Index,int numPeb){
        //Base case
        if(numPeb ==0){
            int k = Player.regArr()[Index].getPebNum();
            Hole b = new Hole(k+1);
            Player.regArr()[Index] = b;
            return;
        }
        else {

            //Recursion
            //NextIndex
            int newIndex = Index+1;
            int newNumPeb = numPeb - 1;
            Distribute(Player,newIndex,newNumPeb);
            //Get the number of Pebbles in the next Index.
           int k = Player.regArr()[newIndex].getPebNum();
           //Create a hole with the number of pebbles of previous plus 1.
           Hole b = new Hole(k+1);
           //Assign new hole to the index of the region of the array
            Player.regArr()[newIndex] = b;



        }
    }*/
        //However, I do not think a recursion will work because what is happening to the rest of the indices to the right is
        //different from what is happening to the current chosen index.


}
