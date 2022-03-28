import java.util.Scanner;

public class PlayerMovement {
    
    Translate translate = new Translate();
    public char[][] playerLocation;
    public Graphics gr;
    public boolean firstMove = true;
    private int[] lastXY;


    public PlayerMovement(Graphics gr){
        playerLocation = new char[GameSettings.w][GameSettings.h];
        this.gr = gr;
    }

    //TODO: Bug where cordinates are wwrong lmao a1 = a2 and so on

    public int[] getPlayerInput(int lastx, int lasty){
        
        Scanner scan = new Scanner(System.in);
        
        //TODO: on start print out map

        System.out.println("You are now at: " + translate.getLetter(lastx) + lasty);
        System.out.print("Input the coordinate of your desired destination: ");
        
        String input = scan.nextLine();
        
        try{
            int y = Integer.parseInt(input.substring(1));
            int x = translate.getInteger(input.substring(0,1).toUpperCase());

            if(!(x <= GameSettings.w && y <= GameSettings.h)){
                System.out.println("Error: Out of bounds. Try again...\n");
                getPlayerInput(lastx, lasty);
            }
            int[] cords = {x, y};
            CLIUtils.ClearConsole();
            return cords;
        } catch(NumberFormatException e){
            System.out.println("Incorrect answer format brrr...\n");
            getPlayerInput(lastx, lasty);
        }
        return null;
    }

    public char[][] movePlayer(int[] playerCordinates){        
        if(playerCordinates == null){ System.out.println("Error calculating current coordinates");return null;}
        
        int x = playerCordinates[0];
        int y = playerCordinates[1];

        if(this.firstMove){
            playerLocation[x][y] = 'X';
            this.lastXY = playerCordinates;
            this.firstMove = false;
            return playerLocation;    
        }

        playerLocation[x][y] = 'X';
        playerLocation[this.lastXY[0]][this.lastXY[1]] = ' ';
        this.lastXY =  playerCordinates;

        return playerLocation;
    }

}
