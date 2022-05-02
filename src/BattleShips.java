import java.util.ArrayList;
import java.util.Scanner;

public class BattleShips {
    public static int numRows = 10;
    public static int numCols = 10;
    public static int playerShips;
    public static int computerShips;

    public static ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
    public static int[][] missedGuesses = new int[numRows][numCols];


    public static void columnTH(){
        System.out.print("   ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();
    }
    public static void createOceanMap(){
        //First section of Ocean Map
        columnTH();
        //Middle section of Ocean Map
        char x = 65;
        for(int i = 0; i < numRows; i++) {
            grid.add(new ArrayList<String>());
            for (int j = 0; j < numCols; j++) {
                grid.get(i).add(0," ");
                if (j == 0)
            System.out.print(x+""+i+"|" + grid.get(i).get(j));
        else if (j == 9)
            System.out.print(grid.get(i).get(j) + "|" + x +"" +i);
        else
            System.out.print(grid.get(i).get(j));

            }

            System.out.println();
            x++;
        }

        //Last section of Ocean Map
        columnTH();
    }


    public static void deployPlayerShips(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nDeploy your ships:");
        //Deploying five ships for player
        BattleShips.playerShips = 5;
        System.out.println("Enter the Coordinate Numbers eg:(1,1)");
        for (int i = 1; i <= BattleShips.playerShips; ) {
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            int y = input.nextInt();

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid.get(x).get(y).contains(" ")))
            {
                grid.get(x).add(y,"@");
                i++;
            }
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid.get(x).get(y).contains("@"))
                System.out.println("You can't place two or more ships on the same location");
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }
        printOceanMap();
    }

    public static void deployComputerShips(){
        System.out.println("\nComputer is deploying ships");
        //Deploying five ships for computer
        BattleShips.computerShips = 5;
        for (int i = 1; i <= BattleShips.computerShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid.get(x).get(y).contains(" ")))
            {
                grid.get(x).add(y,"x");
                System.out.println(i + ". ship DEPLOYED");
                i++;
            }
        }
        printOceanMap();
    }

    public static void Battle(){
        playerTurn();
        computerTurn();

        printOceanMap();

        System.out.println();
        System.out.println("Your ships: " + BattleShips.playerShips + " | Computer ships: " + BattleShips.computerShips);
        System.out.println();
    }

    public static void playerTurn(){
        System.out.println("\nYOUR TURN");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid.get(x).get(y).contains("x")) //if computer ship is already there; computer loses ship
                {
                    System.out.println("Boom! You sunk the ship!");
                    grid.get(x).set(y,"!"); //Hit mark
                    --BattleShips.computerShips;
                }
                else if (grid.get(x).get(y).contains("@")) {
                    System.out.println("Oh no, you sunk your own ship :(");
                    grid.get(x).set(y,"x");
                    --BattleShips.playerShips;
                    ++BattleShips.computerShips;
                }
                else if (grid.get(x).get(y).contains(" ")) {
                    System.out.println("Sorry, you missed");
                    grid.get(x).set(y,"-");
                }
            }
            else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols))  //invalid guess
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    }

    public static void computerTurn(){
        System.out.println("\nCOMPUTER'S TURN");
        //Guess co-ordinates
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) //valid guess
            {
                if (grid.get(x).get(y).contains("@")) //if player ship is already there; player loses ship
                {
                    System.out.println("The Computer sunk one of your ships!");
                    grid.get(x).set(y,"x");
                    --BattleShips.playerShips;
                    ++BattleShips.computerShips;
                }
                else if (grid.get(x).get(y).contains("x")) {
                    System.out.println("The Computer sunk one of its own ships");
                    grid.get(x).set(y,"!");
                }
                else if (grid.get(x).get(y).contains(" ")) {
                    System.out.println("Computer missed");
                    //Saving missed guesses for computer
                    if(missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;
                }
            }
        }while((x < 0 || x >= numRows) || (y < 0 || y >= numCols));  //keep re-prompting till valid guess
    }

    public static void gameOver(){
        System.out.println("Your ships: " + BattleShips.playerShips + " | Computer ships: " + BattleShips.computerShips);
        if(BattleShips.playerShips > 0 && BattleShips.computerShips <= 0)
            System.out.println("Hooray! You won the battle :)");
        else
            System.out.println("Sorry, you lost the battle");
        System.out.println();
    }

    public static void printOceanMap(){
        System.out.println();
        //First section of Ocean Map
        columnTH();

        //Middle section of Ocean Map
        char z = 65;
        for(int x = 0; x < numRows; x++) {
            System.out.print(z +""+x+ "|");

            for (int y = 0; y < numCols; y++){
                System.out.print(grid.get(x).get(y));
            }

            System.out.println("|" + z +""+x);
            z++;
        }

        //Last section of Ocean Map
        columnTH();
    }
}
