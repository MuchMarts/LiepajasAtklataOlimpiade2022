import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    public String name;
    public Integer batteryCharge;
    private Integer distanceTraveled;
    private boolean rain;
    
    private WorldMap map;
    private Graphics gr;
    private PlayerMovement movement;
    private CheckpointParser ch;

    public Integer lastx;
    public Integer lasty;

    public Player(int start_x, int start_y, Graphics gr, WorldMap map, CheckpointParser ch){
        this.name = "test";//getPlayerName();
        this.batteryCharge = 100;
        this.distanceTraveled = 0;
        this.lastx = start_x;
        this.lasty = start_y;
        this.map = map;
        this.gr = gr;
        this.ch = ch;
        this.movement = new PlayerMovement(gr, map);
    }

    public void setRain(boolean rain){
        this.rain = rain;
    }

    public void chargeBattery(boolean isSuper){
        if(isSuper){
            this.batteryCharge = 150;
        } else {
            this.batteryCharge = 100;
        }    
    }

    private void useBattery(int distance, boolean rain){
        if(!rain){
            this.batteryCharge = (int) (this.batteryCharge - distance * GameSettings.distanceCost);
        }else{
            this.batteryCharge = (int) (this.batteryCharge - distance * GameSettings.distanceCostRain);
        }
    }

    public Integer getDistanceTraveled(){
        return distanceTraveled;
    }

    private void updateDistanceTraveled(int distance){
        this.distanceTraveled = this.distanceTraveled + distance;
    }
    //TODO: fix random cord bugs and also maybe draw map before input as not to rely on it being drawn before
    public void playerMove(){

        movement.getPlayerInput(lastx, lasty);
        int[][] path = movement.movePlayer(movement.outCords);  
            
        if(path == null){
            System.out.println("Path incorectly generated");
            return;
        }

        int[] lastCords = new int[2];

        for(int[] playerPos : path){
            lastCords[0] = this.lastx;
            lastCords[1] = this.lasty;

            if(playerPos[0] == this.lastx && playerPos[1] == this.lasty){
                this.lastx = playerPos[0];
                this.lasty = playerPos[1];
            } else {
                map.movePlayer(playerPos, lastCords);
                useBattery(GameSettings.stepSize, this.rain);
                updateDistanceTraveled(GameSettings.stepSize);
                Render.drawMapAnim(this.map, this.gr, this.batteryCharge);
                this.lastx = playerPos[0];
                this.lasty = playerPos[1];
            }
        }
        //manageLocations();
    }

    public void manageLocations(){
        Scanner sc = new Scanner(System.in);
        String coor = ch.getLetter(lastx) + Integer.toString(lasty + 1);
        boolean answer = false;
        while(!answer){
            if(ch.isCheckPoint(coor)){
                System.out.println("Location: " + ch.checkpointsInAMap().get(coor).get("name"));
                System.out.println(ch.checkpointsInAMap().get(coor).get("task"));
                String user_answer = sc.nextLine();
                ArrayList<String> arr = new ArrayList<>(Arrays.asList(ch.checkpointsInAMap().get(coor).get("answer").split(", ")));
                if(!arr.contains(user_answer.toUpperCase())){
                    System.out.println("Wrong answer... Try again!");
                    answer = false;
                }else{
                    answer = true; break;
                }
            }else if(ch.isChargeStation(coor)){

                System.out.println("Location: " + ch.chargeStationsInAMap().get(coor).get("name"));
                if(ch.chargeStationsInAMap().get(coor).get("name") == "SuperCharge"){
                    chargeBattery(true);
                    answer = true; break;
                }else{
                    chargeBattery(false);
                    answer = true; break;
                }
            }
        }            
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
        CLIUtils.ClearConsole();
        return name;
    }

}
