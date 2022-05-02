public class Main {
    public static void main(String[] args) {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("Right now, sea is empty\n");

        BattleShips battleShips = new BattleShips();
        //Step 1 – Create the ocean map
        battleShips.createOceanMap();

        //Step 2 – Deploy player’s ships
        battleShips.deployPlayerShips();

        //Step 3 - Deploy computer's ships
        battleShips.deployComputerShips();

        //Step 4 Battle
        do {
            battleShips.Battle();
        }while(BattleShips.playerShips != 0 && BattleShips.computerShips != 0);

        //Step 5 - Game over
        battleShips.gameOver();

    }

}