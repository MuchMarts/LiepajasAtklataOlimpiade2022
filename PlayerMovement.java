import java.util.Scanner;

public class PlayerMovement {
    
    Translate translate = new Translate();
    public char[][] playerLocation;
    public PlayerMovement(){
    playerLocation = new char[GameSettings.w][GameSettings.h];
    }

    public int[] getPlayerInput(int lastx, int lasty){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Tu tagad atrodies: " + translate.getLetter(lastx) + lasty);
        System.out.print("Ievadi koordinaatu, kur veelies doties: ");
        
        String input = scan.nextLine();
        
        try{
            int y = Integer.parseInt(input.substring(1));
            int x = translate.getInteger(input.substring(0,1).toUpperCase());

            if(!(x <= GameSettings.w && y <= GameSettings.h)){
                System.out.println("Error: Out of bounds. Try again...");
                getPlayerInput(lastx, lasty);
            }
            int[] cords = {x,y};
            return cords;
        } catch(NumberFormatException e){
            System.out.println("Incorrect answer format brrr");
            getPlayerInput(lastx, lasty);
        }
        return null;
    }

    public char[][] movePlayer(int[] playerCordinates){        
        if(playerCordinates == null){ System.out.println("Error calculating  current coordinates");return null;}
        
        playerLocation[playerCordinates[0]][playerCordinates[1]] = 'X';
        
        return playerLocation;
    }

}
