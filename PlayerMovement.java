import java.util.Scanner;

public class PlayerMovement {
    
    Translate translate = new Translate();
    public Graphics gr;
    public boolean firstMove = true;
    private int[] lastXY;
    private WorldMap map;

    //TODO: Validate that move aint bigger than ur battery
    public PlayerMovement(Graphics gr, WorldMap map){
        this.gr = gr;
        this.map = map;
        this.lastXY = new int[2];
    }

    public int[] getPlayerInput(int lastx, int lasty){
        
        Scanner scan = new Scanner(System.in);
        
        if(this.firstMove){ this.lastXY[0] = lastx; this.lastXY[0] = lasty; this.firstMove = false; }

        System.out.println("You are now at: " + translate.getLetter(lastx) + (lasty + 1));
        System.out.print("Input the coordinate of your desired destination: ");
        
        String input = scan.nextLine();
        int[] cords = new int[2];

        try{
            int y = Integer.parseInt(input.substring(1));
            int x = translate.getInteger(input.substring(0,1).toUpperCase());

            if(x > GameSettings.w && y > GameSettings.h){
                System.out.println("Error: Out of bounds. Try again...\n");
                getPlayerInput(lastx, lasty);
            } else {
            cords[0] = x; cords[1] = y - 1;
            CLIUtils.ClearConsole();
            movePlayer(cords);
            return cords;
            }
        } 
        catch(NumberFormatException e){
            System.out.println("Incorrect answer format brrr...\n");
            getPlayerInput(lastx, lasty);
        }
        return null;
    }

    private void movePlayer(int[] playerCordinates){        
        if(playerCordinates == null){ System.out.println("Error calculating current coordinates");}
        this.lastXY = map.movePlayer(playerCordinates, this.lastXY);
    }
}

