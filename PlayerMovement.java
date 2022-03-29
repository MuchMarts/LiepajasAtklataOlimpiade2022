import java.util.Scanner;

import javax.swing.InputMap;
import javax.swing.text.IconView;

public class PlayerMovement {
    
    Translate translate = new Translate();
    public Graphics gr;
    public boolean firstMove = true;
    public int[] outCords;
    private int[] lastXY;
    private WorldMap map;

    //TODO: Validate that move aint bigger than ur battery
    public PlayerMovement(Graphics gr, WorldMap map){
        this.gr = gr;
        this.map = map;
        this.lastXY = new int[2];
        this.outCords = new int[2];
    }

    public boolean checkInputValidity(String input){
        if(input.length() > 1){
            if(translate.getInteger(input.substring(0,1).toUpperCase()) != -1){
                return true;
            }
        }
        return false;
    }

    public void getPlayerInput(int lastx, int lasty){
        
        Scanner scan = new Scanner(System.in);
        int[] cords = new int[2];
        
        System.out.println("You are now at: " + translate.getLetter(lastx) + (lasty + 1));
        System.out.print("Input the coordinate of your desired destination: ");
        String input = scan.nextLine();
        
        if(checkInputValidity(input)){    
            try{
                
                int y = Integer.parseInt(input.substring(1));
                int x = translate.getInteger(input.substring(0,1).toUpperCase());

                if(x > GameSettings.w || y > GameSettings.h){
                    System.out.println("Error: Out of bounds. Try again...\n");
                    getPlayerInput(lastx, lasty);
                } else {
                if(this.firstMove){ this.lastXY[0] = lastx; this.lastXY[0] = lasty; this.firstMove = false;}
                
                cords[0] = x; cords[1] = y - 1;
                CLIUtils.ClearConsole();
                
                movePlayer(cords);
                this.outCords = cords;
            }
            } 
            catch(NumberFormatException e){
                System.out.println("Incorrect answer format brrr...\n");
                getPlayerInput(lastx, lasty);
            } 
        } else {
            System.out.println("Answer in wrong format. Try again.");
            getPlayerInput(lastx, lasty);
        }
    }

    private void movePlayer(int[] playerCordinates){        
        if(playerCordinates == null){ System.out.println("Error calculating current coordinates");}
        this.lastXY = map.movePlayer(playerCordinates, this.lastXY);
    }
}

