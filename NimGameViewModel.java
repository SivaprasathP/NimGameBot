import java.util.Scanner;

public class NimGameViewModel {

    public void remove(int[] sticks, Scanner scanner) {
        System.out.println("Enter the Row number(1->4): ");
        int row = 0;
        boolean isNotFirstCall = false;
        do {
            if (row > 0 && sticks[row - 1] == 0) {
                System.out.println("There is no sticks in that row,please select another row");
            } else if (isNotFirstCall) {
                System.out.println("Please enter a valid Row Number (1->4)");
            }
            row = scanner.nextInt();
            isNotFirstCall = true;
        } while (row < 1 || row > 4 || sticks[row - 1] == 0);


        isNotFirstCall = false;
        System.out.println("Enter the number of the sticks to be removed: ");
        int noOfSticks = 0;

        do {
            if (isNotFirstCall) {
                System.out.println("Please enter a valid number of sticks to be removed");
            }
            noOfSticks = scanner.nextInt();
            isNotFirstCall = true;
        } while (sticks[row - 1] - noOfSticks < 0 || noOfSticks <= 0);

        sticks[row - 1] = sticks[row - 1] - noOfSticks;
    }

    public boolean isWinner(int[] sticks) {
        for (int i : sticks) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public void computersTurn(int[] sticks) {
        int nonZeroRows = 0;
        for (int i = 0; i < 4; i++) {
            if (sticks[i] > 0) {
                nonZeroRows++;
            }
        }

        int maxRow = -1;
        int maxSticks = 0;
        int minSticks = 7;

        for (int i = 0; i < 4; i++) {
            if (maxSticks < sticks[i]) {
                maxRow = i;
                maxSticks = sticks[i];
            }
            if (sticks[i] != 0 && sticks[i] < minSticks) {
                minSticks = sticks[i];
            }
        }

        if (nonZeroRows == 2 && minSticks == 1 && maxSticks != 1) {// 1 3
            sticks[maxRow] = 0;
            return;
        }



        if (nonZeroRows == 3 && minSticks == 1 && maxSticks ==2) {//1 2 1
            int count2=0;
            for(int i:sticks){
                count2=i==2?count2+1:count2;
            }
            if(count2==1){
                sticks[maxRow] = 1;
                return;
            }
        }




        for (int i = 0; i < 4; i++) {
            if (sticks[i] == 0) {
                continue;
            }

            int temp = sticks[i];
            for (int j = 0; j < temp; j++) {
                sticks[i]--;
                if (isXorZero(sticks) && nonZeroRows > 1) {
                    return;
                }
            }

            sticks[i] = temp;
        }


        if (nonZeroRows == 1 && sticks[maxRow] > 1) {
            sticks[maxRow] = 1;
            return;
        }


        sticks[maxRow]--;
    }

    private boolean isXorZero(int[] sticks) {
        int xor = 0;
        for (int i : sticks) {
            xor ^= i;
        }

        return xor == 0;
    }
}
