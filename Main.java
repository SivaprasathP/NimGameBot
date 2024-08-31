import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int[] sticks={1,3,5,7};

        System.out.println("Welcome To Nim Game");
        System.out.println("==============================================");

        System.out.println("Game Instructions: ");
        NimGameView view=new NimGameView();
        view.displaySticks(sticks);

        System.out.println("Objective: \n"+
                        "\n"+
                        "The aim of the Nim game is to avoid being the player who has to pick the last stick. \n"+
                        "The player who is forced to pick the last stick loses the game.\n"+
                        "\n");

        System.out.println("Game Rules:\n" +
                "\n" +
                "1. On your turn, you must remove one or more sticks from a single row.\n" +
                "2. You can remove any number of sticks (as long as you remove at least one), but only from one row.\n" +
                "3. After removing the sticks, the computer takes it's turn.\n" +
                "4. The game continues until one of you is forced to take the last stick. The one who takes the last stick loses the game.\n" +
                "\n");

        System.out.println("==============================================");


        while(true){
            view.displayChoice();
            int choice=scanner.nextInt();

            if(choice==1){
                sticks=new int[]{1,3,5,7};
                NimGameViewModel nimGame=new NimGameViewModel();

                while(true){
                    if(nimGame.isWinner(sticks)){
                        System.out.println("Player1 is the Winner");
                        break;
                    }

                    view.displaySticks(sticks);
                    System.out.println("Player1's turn:");
                    nimGame.remove(sticks,scanner);

                    if(nimGame.isWinner(sticks)){
                        System.out.println("Computer is the Winner");
                        break;
                    }

                    view.displaySticks(sticks);
                    System.out.println("Computer's turn:");
                    nimGame.computersTurn(sticks);

                    if(nimGame.isWinner(sticks)){
                        System.out.println("Player1 is the Winner");
                        break;
                    }
                }
            }else if(choice==2){
                break;
            }else{
                System.out.println("Please enter a valid option");
            }
        }
        System.out.println("----------Thank You------------");
    }
}