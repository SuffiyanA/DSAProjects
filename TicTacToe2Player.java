package com.mycompany.tictactoe2player;
import java.util.Scanner; 

/**
 *
 * @author DSU
 */
public class TicTacToe2Player {
    
    
    //method to write the symbol on the position determined by the player
    //returns a string and takes an array and the position(selected by player) as arguments
    static String filler(int[] arr, int pos){
        String userAns = " ";        
            if (arr[pos]==0){
                userAns =  " ";
            } else if (arr[pos]==1){
                userAns = "1";
            } else {
                userAns = "0";
            }
        
        return userAns;
    }
    
   
    //single method that checks if the user has input an invalid value (>8 or <0)or if the user has selected a position thats already been occupied
    static int positionChecker(int[] arr, int x){
        int factor = 1;
        if(x<0 || x>8){
            factor = 0;
            System.out.println("Please enter a position thats between 0 and 8");
        } else  if (arr[x] != 0){
            factor = 0;
            System.out.println("This position has already been filled, please choose another position");
        }
        else {
            factor = 1;
        }
        return factor;
    }
    
    
    //method to determine the winner of the game. It crawls through the whole array and looks for pre-defined combinations that could signal who has won the game. If no winner is determined, it returns 0 but returns 1 for player who used 1 and 2 for player who used 2.
    static int boardChecker(int[] arr){
        int winner=0;
        if (arr[0]==arr[1] && arr[1]==arr[2]){
            if (arr[1]!=0){
                winner = arr[1];
            }
        } else if (arr[0]==arr[4] && arr[4]==arr[8]){
            if (arr[1]!=0){
                winner = arr[4];
            }
        } else if (arr[0]==arr[3] && arr[3]==arr[6]){
            if (arr[1]!=0){
                winner = arr[3];
            }
        } else if (arr[3]==arr[4] && arr[4]==arr[5]){
            if (arr[1]!=0){
                winner = arr[4];
            }
        } else if (arr[6]==arr[7] && arr[7]==arr[8]){
            if (arr[1]!=0){
                winner = arr[7];
            }
        } else if (arr[1]==arr[4] && arr[4]==arr[7]){
            if (arr[1]!=0){
                winner = arr[4];
            }
        } else if (arr[2]==arr[5] && arr[5]==arr[8]){
            if (arr[1]!=0){
                winner = arr[5];
            }
        } else if (arr[2]==arr[4] && arr[4]==arr[6]){
            if (arr[1]!=0){
                winner = arr[4];
            }
        }
        return winner;
        
    }
    
    public static void main(String[] args) {
        
        //initial printing of the board so that users can familiarize themselves with the positions
        System.out.println("    |   |   ");
        System.out.println("  0 | 1 | 2 ");
        System.out.println("_____________");
        System.out.println("    |   |   ");
        System.out.println("  3 | 4 | 5 ");
        System.out.println("_____________");
        System.out.println("  6 | 7 | 8 ");
        System.out.println("    |   |   ");
        
        int[] ans = new int[]{0,0,0,0,0,0,0,0,0};
        
        Scanner userIn = new Scanner(System.in);
        
        int inFlag = 1;
        int gameFlag =0;
        int position = 0;
        for (int z =0; z<9 && gameFlag==0; z++){
            
            int positionFlag = 0;
            
            //using positionFlag to counter the same position being chosen. If an occupied position is selected, the user gets stuck in a loop until he enters an unoccupied position
            while (positionFlag==0){
            
                System.out.println("Enter position");

                position = userIn.nextInt();
                
                //positionChecker ingests the array value at the position chosen by the player and returns a flag value that determines whether the player has chosen a preoccupied position or not.
                positionFlag = positionChecker(ans, position);

            }
            
            //inFlag used to switch ebtween input of 1 and 0
            if (inFlag==1){
                ans[position] = 1;
            } else {
                ans[position] = 2;
            }
            
            
            //printing of the board
            //filler method takes the array as well as the position of the array so that value stored can be printed on the screen. If the value stored in that position is 0, empty space is returned.
            //each position in the board is filled by using the filler method which returns a string that can be displayed on the screen.
            String p0 = filler(ans, 0);
            String p1 = filler(ans, 1);
            String p2 = filler(ans, 2);
            String p3 = filler(ans, 3);
            String p4 = filler(ans, 4);
            String p5 = filler(ans, 5);
            String p6 = filler(ans, 6);
            String p7 = filler(ans, 7);
            String p8 = filler(ans, 8);
            System.out.println("    |   |   ");
            System.out.println("  "+p0+" | "+p1+" | "+p2+" ");
            System.out.println("_________________");
            System.out.println("    |   |   ");
            System.out.println("  "+p3+" | "+p4+" | "+p5+" ");
            System.out.println("_________________");
            System.out.println("  "+p6+" | "+p7+" | "+p8+" ");
            System.out.println("    |   |   ");

            
            
            //switching inFlag value for the next turn
            if (inFlag==1){
                inFlag=2;
            } else {
               inFlag=1;
            }

            // boardChecker function checks the whole board and looks for combinations that could determine the winner. It returns an integer, either 1 or 0
            int result = boardChecker(ans);
            if (result != 0){
                if (result ==2){
                    System.out.println("The player who used 0 wins!");
                }
                 else {
                    System.out.println("The player who used "+ result +" wins!");
                } 
                gameFlag=1;
            } else if (result ==0 && z==8) //integer z checks if all 8 moves have been completed. Pairing that with the condition of result, allows us to check if the game has drawn or players have no moves left
                System.out.println("Game drawn with no winner");
            }

    }
}
