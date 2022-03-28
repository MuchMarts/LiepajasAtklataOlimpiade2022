import java.lang.reflect.Type;
import java.util.Scanner;

public class Player {
    public String name;
    public Integer batteryCharge;
    private Integer distanceTraveled;
    private PlayerMovement movement;
    
    public Integer lastx;
    public Integer lasty;

    public Player(int start_x, int start_y, Graphics gr){
        this.name = getPlayerName();
        this.batteryCharge = 100;
        this.distanceTraveled = 0;
        this.lastx = start_x;
        this.lasty = start_y;
        this.movement = new PlayerMovement(gr);
    }

    public void chargeBattery(){
        this.batteryCharge = 100;
    }

    private void useBattery(int distance){
        this.batteryCharge = (int) (this.batteryCharge - distance * GameSettings.distanceCost);
    }

    public Integer getDistanceTraveled(){
        return distanceTraveled;
    }

    private void updateDistanceTraveled(int distance){
        this.distanceTraveled = this.distanceTraveled + distance;
    }

    public char[][] playerMove(){
        int[] playerCordinates = movement.getPlayerInput(lastx, lasty);
        
        int x = playerCordinates[0];
        int y = playerCordinates[1];
        
        char[][] playerLocation = movement.movePlayer(playerCordinates);

        int distance = GameHelper.calculateDistanceTraveled(lastx, lasty, x, y);
        updateDistanceTraveled(distance);
        useBattery(distance);

        this.lastx = x;
        this.lasty = y;

        return playerLocation;
    }

    public String getPlayerName(){
        Scanner sc = new Scanner(System.in);
        
        boolean finalChoice = false;
        String name = "Player";

        System.out.println("What's your name?");

        while(!finalChoice){
            System.out.println("Player name: ");
            name = sc.next();
            
            boolean choiceValid = false;
            //TODO: Make this better 1/0 input is kinda dumb
            while(!choiceValid){
                System.out.println("Is this your final choice: " + name);
                System.out.println("Yes - [1]\nI want to change it - [0]");
            
                Integer choice = sc.nextInt();
                
                System.out.println(choice);

                if(choice == 1){finalChoice = true; break;}
                if(choice == 0){break;}
                System.out.println("Invalid choice: " + choice + "\nTry again!");;
                choiceValid = false;}

        }
        return name;
    }

}
