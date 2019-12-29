public class Project {
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

           Region x;
           Region y;
           int totalScore = 0;
        while(totalScore<44) {

            System.out.println("Print Player Number now:");
            int PlayerTracker = StdIn.readInt();//or Integer.parseInt(args[0]);
            if (PlayerTracker != 1 && PlayerTracker != 2) {
                System.err.println("The Player Number must be either 1 or 2. Try again:");
                continue;
            } else {
                if (PlayerTracker == 1) {
                x = Player1;
                y = Player2;
            } else {
                x = Player2;
                y = Player1;
            }
            //I will use the next line as a parameter for my draw method.
            int OtherPlayer;
            //Variable to Check if the x and y are switched
            int switchTracker = 0;
            if (PlayerTracker == 1) {
                OtherPlayer = 2;
            } else {
                OtherPlayer = 1;
            }
            System.out.println("Print index of player now:");
            int Index = StdIn.readInt();// Integer.parseInt(args[1]);
            //Recursion/ for loop?
            //Try recursion first.
            //Recursion outside main statement
            //Try a for loop next
            //Put the number of pebbles at inputted index into hands

            if (Index > 5 || Index < 0) {
                System.err.println("Please input player number again with with another index. Index must only be between 0 and 5 inclusive ");
                continue;
            }
            int pebNumInHands = x.regArr()[Index].getPebNum();
            if (pebNumInHands == 0) {
                System.err.println("Please choose another index. No pebbles in current index");
            } else {
                //Set the selected index to 0.
                Hole tempHole = new Hole(0);
                x.regArr()[Index] = tempHole;


                //Code to distribute pebbles in player1's region
                int i;


                while (true) {
                    int ArrayTracker = pebNumInHands;
                    int pebLeft = pebNumInHands;
                    for (i = Index + 1; i < 6; i++) {
                        int pebNumAtIndexI = x.regArr()[i].getPebNum();
                        Hole newHole = new Hole(pebNumAtIndexI + 1);

                        x.regArr()[i] = newHole;
                        System.out.println("NewHole pebNum: " + x.regArr()[i].getPebNum());
                        //Code to draw the oware after each move

                        StdDraw.clear();
                        x.drawEntireRegion(PlayerTracker);
                        y.drawEntireRegion(OtherPlayer);

                        StdDraw.pause(15);
                        //System.out.println(x.regArr()[i].getPebNum());
                        Hole HandHole = new Hole(pebNumInHands - 1);
                        pebNumInHands = HandHole.getPebNum();
                        System.out.println("pebNum in Hands :" + pebNumInHands);
                        //Code to check if the number of pebbles in the box is 4 and there are no pebbles in hand
                        //and add the scores to the current player's
                        if ((x.regArr()[i].getPebNum() == 4 || x.regArr()[i].getPebNum() == 13) && pebNumInHands == 0) {
                            if (x.regArr()[i].getPebNum() == 4 && pebNumInHands == 0) {
                                x.addScore(4);
                                Hole tempHole2 = new Hole(0);
                                x.regArr()[i] = tempHole2;
                                x.drawEntireRegion(PlayerTracker);
                                y.drawEntireRegion(OtherPlayer);
                                break;

                            } else if (x.regArr()[i].getPebNum() == 13 && pebNumInHands == 0) {
                                x.addScore(13);
                                Hole tempHole2 = new Hole(0);
                                x.regArr()[i] = tempHole2;
                                x.drawEntireRegion(PlayerTracker);
                                y.drawEntireRegion(OtherPlayer);
                                break;
                            }
                        } else if (x.regArr()[i].getPebNum() == 4 || x.regArr()[i].getPebNum() == 13) {
                            if (x.regArr()[i].getPebNum() == 4) {
                                x.addScore(4);
                                Hole tempHole2 = new Hole(0);
                                x.regArr()[i] = tempHole2;
                                x.drawEntireRegion(PlayerTracker);
                                y.drawEntireRegion(OtherPlayer);
                            } else if (x.regArr()[i].getPebNum() == 13) {
                                x.addScore(13);
                                Hole tempHole2 = new Hole(0);
                                x.regArr()[i] = tempHole2;
                                x.drawEntireRegion(PlayerTracker);
                                y.drawEntireRegion(OtherPlayer);
                            }
                        }

                        // System.out.println(pebNumInHands);

                        if (pebNumInHands == 0) {
                            break;
                        }

                    }
                    pebLeft = pebNumInHands;
                    if (pebNumInHands == 0) {
                        pebNumInHands = x.regArr()[i].getPebNum();
                        if (pebNumInHands == 0 || pebNumInHands == 1) {
                            x.drawEntireRegion(PlayerTracker);
                            y.drawEntireRegion(OtherPlayer);
                            break;
                        }
                        Hole justCleared = new Hole(0);
                        x.regArr()[i] = justCleared;
                        Index = i;
                        continue;
                    }

                    //Code to distribute pebbles in player2's region after player1.
                    //if there are more pebbles left in the hand after distributing to holes in the present region,
                    // continue in the next region.

                    if (pebLeft > 0) {
                        int j;
                        for (j = 0; j < 6; j++) {
                            int pebNumAtIndexJ = y.regArr()[j].getPebNum();
                            //System.out.println(pebNumAtIndexJ);
                            Hole newHole = new Hole(pebNumAtIndexJ + 1);
                            y.regArr()[j] = newHole;
                            System.out.println("NewHole pebNum: " + y.regArr()[j].getPebNum());
                            Hole HandHole = new Hole(pebNumInHands - 1);
                            //Code to draw the oware after each move

                            StdDraw.clear();
                            x.drawEntireRegion(PlayerTracker);
                            y.drawEntireRegion(OtherPlayer);

                            StdDraw.pause(15);
                            pebNumInHands = HandHole.getPebNum();
                            //Update the number of pebbles left.
                            pebLeft = HandHole.getPebNum();
                            System.out.println("pebNum in Hands :" + pebNumInHands);
                            //Code to check if the number of pebbles in the box is 4 and there are no pebbles in hand
                            //and add the scores to the current player's
                            if ((y.regArr()[j].getPebNum() == 4 || y.regArr()[j].getPebNum() == 13) && pebNumInHands == 0) {
                                if (y.regArr()[j].getPebNum() == 4) {
                                    x.addScore(4);
                                    Hole tempHole2 = new Hole(0);
                                    y.regArr()[j] = tempHole2;
                                    x.drawEntireRegion(PlayerTracker);
                                    y.drawEntireRegion(OtherPlayer);
                                    break;
                                } else if (y.regArr()[j].getPebNum() == 13) {
                                    x.addScore(13);
                                    Hole tempHole2 = new Hole(0);
                                    y.regArr()[i] = tempHole2;
                                    x.drawEntireRegion(PlayerTracker);
                                    y.drawEntireRegion(OtherPlayer);
                                    break;
                                }
                            } else if (y.regArr()[j].getPebNum() == 4 || y.regArr()[j].getPebNum() == 13) {
                                if (y.regArr()[j].getPebNum() == 4) {
                                    y.addScore(4);
                                    Hole tempHole2 = new Hole(0);
                                    y.regArr()[j] = tempHole2;
                                    x.drawEntireRegion(PlayerTracker);
                                    y.drawEntireRegion(OtherPlayer);
                                } else if (y.regArr()[j].getPebNum() == 13) {
                                    y.addScore(13);
                                    Hole tempHole2 = new Hole(0);
                                    y.regArr()[j] = tempHole2;
                                    x.drawEntireRegion(PlayerTracker);
                                    y.drawEntireRegion(OtherPlayer);
                                }
                            }

                            //System.out.println(pebNumInHands);
                            if (pebNumInHands == 0) {
                                break;
                            }

                        }
                        if (pebNumInHands == 0) {
                            pebNumInHands = y.regArr()[j].getPebNum();
                            if (pebNumInHands == 0 || pebNumInHands == 1) {
                                x.drawEntireRegion(PlayerTracker);
                                y.drawEntireRegion(OtherPlayer);
                                break;
                            }

                            Hole justCleared = new Hole(0);
                            y.regArr()[j] = justCleared;
                            Index = j;
                            //The next codes switch the regions to start with and end.
                            Region k;
                            k = y;
                            y = x;
                            x = k;
                            switchTracker++;
                            if (switchTracker % 2 == 1) {
                                if (PlayerTracker == 1) {
                                    Player2 = x;
                                    Player1 = y;
                                } else if (PlayerTracker == 2) {
                                    Player1 = x;
                                    Player2 = y;
                                }
                            } else if (switchTracker % 2 == 0) {
                                if (PlayerTracker == 1) {
                                    Player1 = x;
                                    Player2 = y;
                                } else if (PlayerTracker == 2) {
                                    Player2 = x;
                                    Player1 = y;
                                }
                            }
                            continue;
                        }


                        //if there are still more pebbles Left after filling the next region, go to the previous region.
                        if (pebLeft > 0) {
                            for (i = 0; i < 6; i++) {
                                int pebNumAtIndexI = x.regArr()[i].getPebNum();
                                Hole newHole = new Hole(pebNumAtIndexI + 1);
                                x.regArr()[i] = newHole;
                                System.out.println("NewHole pebNum: " + x.regArr()[i].getPebNum());
                                Hole HandHole = new Hole(pebNumInHands - 1);
                                //Code to draw the oware after each move
                                StdDraw.clear();
                                x.drawEntireRegion(PlayerTracker);
                                y.drawEntireRegion(OtherPlayer);

                                StdDraw.pause(15);
                                pebNumInHands = HandHole.getPebNum();
                                System.out.println("pebNum in Hands :" + pebNumInHands);
                                //Update the number of pebbles left.
                                pebLeft = HandHole.getPebNum();

                                //Code to check if the number of pebbles in the box is 4 and there are no pebbles in hand
                                //and add the scores to the current player's
                                if ((x.regArr()[i].getPebNum() == 4 || x.regArr()[i].getPebNum() == 13) && pebNumInHands == 0) {
                                    if (x.regArr()[i].getPebNum() == 4) {
                                        x.addScore(4);
                                        Hole tempHole2 = new Hole(0);
                                        x.regArr()[i] = tempHole2;
                                        x.drawEntireRegion(PlayerTracker);
                                        y.drawEntireRegion(OtherPlayer);
                                        break;
                                    } else if (x.regArr()[i].getPebNum() == 13) {
                                        x.addScore(13);
                                        Hole tempHole2 = new Hole(0);
                                        x.regArr()[i] = tempHole2;
                                        x.drawEntireRegion(PlayerTracker);
                                        y.drawEntireRegion(OtherPlayer);
                                        break;
                                    }
                                } else if (x.regArr()[i].getPebNum() == 4 || x.regArr()[i].getPebNum() == 13) {
                                    if (x.regArr()[i].getPebNum() == 4) {
                                        x.addScore(4);
                                        Hole tempHole2 = new Hole(0);
                                        x.regArr()[i] = tempHole2;
                                        x.drawEntireRegion(PlayerTracker);
                                        y.drawEntireRegion(OtherPlayer);
                                    } else if (x.regArr()[i].getPebNum() == 13) {
                                        x.addScore(13);
                                        Hole tempHole2 = new Hole(0);
                                        x.regArr()[i] = tempHole2;
                                        x.drawEntireRegion(PlayerTracker);
                                        y.drawEntireRegion(OtherPlayer);
                                    }
                                }

                                if (pebNumInHands == 0) {
                                    break;
                                }
                            }
                            pebLeft = pebNumInHands;
                            if (pebNumInHands == 0) {
                                pebNumInHands = x.regArr()[i].getPebNum();
                                if (pebNumInHands == 0 || pebNumInHands == 1) {
                                    x.drawEntireRegion(PlayerTracker);
                                    y.drawEntireRegion(OtherPlayer);
                                    break;
                                }
                                Hole justCleared = new Hole(0);
                                x.regArr()[i] = justCleared;
                                Index = i;
                                continue;
                            }

                        }
                        //Per the way the game is, after running all these steps, the number of pebbles in the original hole should have finished.
                    }

                }

                if (PlayerTracker == 1) {

                    StdDraw.clear();
                    Player1.drawEntireRegion(PlayerTracker);
                    Player2.drawEntireRegion(OtherPlayer);
                    StdDraw.pause(30);
                } else {

                    StdDraw.clear();
                    Player2.drawEntireRegion(PlayerTracker);
                    Player1.drawEntireRegion(OtherPlayer);
                    StdDraw.pause(30);
                }
            }
            totalScore = Player1.getScore() + Player2.getScore();
        }
       }
        System.out.println("GAME OVER!");
        if(Player1.getScore()>Player2.getScore()){
            System.out.println("Congratulations Player1. YOU WIN");
        }
        else if(Player2.getScore() > Player1.getScore()){
            System.out.println("Congratulations Player2. YOU WIN");
        }
        else{
            System.out.println("That was a good game!. DRAW");
        }



    }



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
