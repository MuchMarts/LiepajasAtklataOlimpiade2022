import java.util.Scanner;

public class PlayerMovement {
    
    Translate translate = new Translate();
    public char[][] playerLocation;
    public PlayerMovement(){
    playerLocation = new char[GameSettings.w][GameSettings.h];
    }

    public int[] getPlayerInput(){
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        
        try{
            int y = Integer.parseInt(input.substring(1));
            int x = translate.getInteger(input.substring(0,1).toUpperCase());

            if(!(x <= GameSettings.w && y <= GameSettings.h)){
                System.out.println("Error: Out of bounds. Try again...");
                getPlayerInput();
            }
            int[] cords = {x,y};
            return cords;
        } catch(NumberFormatException e){
            System.out.println("Incorrect answer format brrr");
            getPlayerInput();
        }
        return null;
    }

    public void movePlayer(int[] cords, WorldMap map){
        if(cords == null){ System.out.println("Error calculating  current coordinates");return;}
        
        Render.drawMap(cords, map);
    
    }

}
