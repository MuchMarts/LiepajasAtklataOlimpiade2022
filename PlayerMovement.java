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

    //TODO: Bug where cordinates are wwrong lmao a1 = a2 and so on

    public int[] getPlayerInput(int lastx, int lasty){
        
        Scanner scan = new Scanner(System.in);
        
        //TODO: on start print out map
        if(this.firstMove){
            Render.drawMap(tempInitMap(lastx, lasty), this.map, gr, 999); 
        }

        System.out.println("Tu tagad atrodies: " + translate.getLetter(lastx) + (lasty));
        System.out.print("Ievadi koordinaatu, kur veelies doties: ");
        
        String input = scan.nextLine();
        
        try{
            int y = Integer.parseInt(input.substring(1));
            int x = translate.getInteger(input.substring(0,1).toUpperCase());

            if(!(x <= GameSettings.w && y <= GameSettings.h)){
                System.out.println("Error: Out of bounds. Try again...\n");
                getPlayerInput(lastx, lasty);
            }
            int[] cords = {x,y};
            CLIUtils.ClearConsole();
            return cords;
        } catch(NumberFormatException e){
            System.out.println("Incorrect answer format brrr\n");
            getPlayerInput(lastx, lasty);
        }
        return null;
    }

    public char[][] movePlayer(int[] playerCordinates){        
        if(playerCordinates == null){ System.out.println("Error calculating  current coordinates");return null;}
        
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
