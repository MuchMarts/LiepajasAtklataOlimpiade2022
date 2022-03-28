import java.util.Scanner;

public class PlayerMovement {
    
    Translate translate = new Translate();
    public char[][] playerLocation;
    private char[][] tempPlayerLocation;
    public Graphics gr;
    public boolean firstMove = true;
    private int[] lastXY;
    private WorldMap map;


    public PlayerMovement(Graphics gr, WorldMap map){
        playerLocation = new char[GameSettings.w][GameSettings.h];
        tempPlayerLocation = new char[GameSettings.w][GameSettings.h];
        this.gr = gr;
        this.map = map;
    }

    public int[] getPlayerInput(int lastx, int lasty){
        
        Scanner scan = new Scanner(System.in);
        
        //TODO: on start print out map
        if(this.firstMove){
            Render.drawMap(tempInitMap(lastx, lasty), this.map, gr, 999); 
        }

        System.out.println("You are now at: " + translate.getLetter(lastx) + (lasty + 1));
        System.out.print("Input the coordinate of your desired destination: ");
        
        String input = scan.nextLine();
        int[] cords = new int[2];

        try{
            int y = Integer.parseInt(input.substring(1));
            int x = translate.getInteger(input.substring(0,1).toUpperCase());

            if(!(x <= GameSettings.w && y <= GameSettings.h)){
                System.out.println("Error: Out of bounds. Try again...\n");
                getPlayerInput(lastx, lasty);
            }
            cords[0] = x; cords[1] = y - 1;
            CLIUtils.ClearConsole();
            return cords;
        } catch(NumberFormatException e){
            System.out.println("Incorrect answer format brrr...\n");
            return null;
        }
        //TODO: fix bug with NumberFormatException
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

    private char[][] tempInitMap(int x, int y){
        this.tempPlayerLocation[x][y] = 'X';
        return tempPlayerLocation;
    }
}
