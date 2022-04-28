import java.util.HashMap;
import java.util.Scanner;

public class RobotInGrid {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, String> robotStep = new HashMap<Integer, String>();

        System.out.println("Welcome to the Robot In a Grid Game!");
        System.out.println("Please enter a number of rows for your grid: ");
        int rows = scan.nextInt();

        System.out.println("Please enter a number of columns for your grid: ");
        int columns = scan.nextInt();

        int[][] emptyGrid = new int[rows][columns];

        int[][] newGrid = generateRandomGrid(emptyGrid);

        System.out.println("Here is your grid: ");
        printGrid(newGrid);

        robotStep.put(0, "Robot has moved right");
        robotStep.put(1, "Robot has moved down");

        int currentRow = 0;
        int currentColumn = 0;
        int currentPosition = newGrid[currentRow][currentColumn];


        while((currentRow != rows - 1) && (currentColumn != columns)) {
            System.out.println("To move right type 0, to move down type 1.");
            System.out.println("The robot cannot move to any zero position.");

            int nextMove = scan.nextInt();

            if(nextMove == 0) {

                int moveRight = currentColumn + 1;

                //Check the value in the right cell.
                int nextPosition = newGrid[currentRow][moveRight];
                if(nextPosition == 0) {
                    System.out.println("Sorry this position has been blocked off.");
                }else if(nextPosition == 1 || nextPosition == 2) {
                    currentColumn = moveRight;
                    currentPosition = newGrid[currentRow][currentColumn];
                    System.out.println("The robot has moved right and is now at position [" + currentRow + "][" + currentColumn + "]");
                }

            }else if(nextMove == 1) {

                int moveDown = currentRow + 1;
                //Check the value in the right cell.
                int nextPosition = newGrid[moveDown][currentColumn];
                if(nextPosition == 0) {
                    System.out.println("Sorry this position has been blocked off.");
                }else if(nextPosition == 1 || nextPosition == 2) {
                    currentRow = moveDown;
                    currentPosition = newGrid[currentRow][currentColumn];
                    System.out.println("The robot has moved down and is now at position [" + currentRow + "][" + currentColumn + "]");
                }

            }
        }

        System.out.println("Congratulations! You've won!");
    }
        public static int[][] generateRandomGrid ( int[][] grid){
            for (int index = 0; index < grid.length; index++) {
                for (int index2 = 0; index2 < grid[index].length; index2++) {
                    //numberGenerated has a range of 0 to 2
                    int numberGenerated = (int) (Math.random() * ((2 - 0) + 1));
                    grid[index][index2] = numberGenerated;
                }
            }

            return grid;
        }

        public static void printGrid(int[][] grid){
            for(int index = 0; index < grid.length; index++) {
                for(int index2 = 0; index2 < grid[index].length; index2++){
                    System.out.print(grid[index][index2]);
                }
                System.out.println();
            }
        }

    }

