public class NimGameView {

    public void displaySticks(int[] sticks) {
        int space=3;
        for(int i=0;i<sticks.length;i++){
            for(int j=1;j<=space;j++){
                System.out.print(" ");
            }

            for(int j=0;j<sticks[i];j++){
                System.out.print("|");
            }

            space--;
            System.out.println();
        }

        System.out.println();
    }

    public void displayChoice() {
        System.out.println("1. Play");
        System.out.println("2. Exit");
        System.out.println("Enter your choice");
    }
}
