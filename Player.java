import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    public String name;
    public Integer batteryCharge;
    private Integer distanceTraveled;
    private boolean rain;
    public int answeredQuestions;
    public String playedTimeString;
    public ArrayList<String> oldCoordinates;
    
    private long startTime;
    private long endTime;
    private long gameTimeMs;
    
    private WorldMap map;
    private Graphics gr;
    private PlayerMovement movement;
    private CheckpointParser ch;

    private Leaderboard lead;

    public Integer lastx;
    public Integer lasty;

    public Player(int start_x, int start_y, Graphics gr, WorldMap map, CheckpointParser ch, Leaderboard leaderboard){
        this.name = getPlayerName();
        this.batteryCharge = 100;
        this.distanceTraveled = 0;
        this.lastx = start_x;
        this.lasty = start_y;
        this.map = map;
        this.gr = gr;
        this.ch = ch;
        this.movement = new PlayerMovement(gr, map);
        this.answeredQuestions = 0;
        this.lead = leaderboard;
        this.oldCoordinates = new ArrayList<>();
    }

    public void startTime(){
        this.startTime = System.currentTimeMillis();
    }
    
    public void endGame(){
        endTime = System.currentTimeMillis();
        
        Long gameTime = endTime - startTime;
        gameTimeMs = gameTime;
         
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        playedTimeString = format.format(gameTimeMs);

        lead.addResult(playedTimeString, this.name);
    }



    public void setRain(boolean rain){
        this.rain = rain;
    }

    private boolean updateAnswered(int x, int y){
        boolean has = false;
        
        if(oldCoordinates.contains(Integer.toString(x) + Integer.toString(y))){
            System.out.println("Hmmm... looks like you've been here already...");
            has = true;
        }
        else{
            this.answeredQuestions++;
            oldCoordinates.add(Integer.toString(x) + Integer.toString(y));
            has = false;
        }
        return has;
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

    public void callTowTruck(){
        System.out.println("Battery died calling Tow Truck!\n");
        CLIUtils.wait(1000);
        String[] animation = {
            "Calling Tow truck",
            ".",
            "..",
            "...",
            ".",
            "..",
            "...",
            "\"Hey coming to pick you up! We will get you to the closest charge point :)\""
        };
        for(String gr : animation){
            CLIUtils.ClearConsole();
            System.out.println(gr);
            CLIUtils.wait(600);
        }
        CLIUtils.wait(2500);

        int[] lastLocation = {lasty, lastx};

        //HARDCODED TIME CONSTRAINTS

        int d1 = (shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[0])).length;
        int d2 = (shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[1])).length;
        int d3 = (shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[2])).length;
        int d4 = (shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[3])).length;    
        
        int[] lastCords = new int[2];

        if(d1 < d2 && d1 < d3 && d1 < d4){
            for(int[] cor : shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[0])){
            lastCords[0] = this.lastx;
            lastCords[1] = this.lasty;

            if(cor[0] == this.lastx && cor[1] == this.lasty){
                this.lastx = cor[0];
                this.lasty = cor[1];
            } else {
                map.movePlayer(cor, lastCords);
                //useBattery(GameSettings.stepSize, this.rain);
                updateDistanceTraveled(GameSettings.stepSize);
                Render.drawTowTruck(map, gr, this.batteryCharge);
                this.lastx = cor[0];
                this.lasty = cor[1];
            }
            }
        } else if(d2 < d1 && d2 < d3 &&d2 < d4){
            for(int[] cor : shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[1])){
                lastCords[0] = this.lastx;
                lastCords[1] = this.lasty;
    
                if(cor[0] == this.lastx && cor[1] == this.lasty){
                    this.lastx = cor[0];
                    this.lasty = cor[1];
                } else {
                    map.movePlayer(cor, lastCords);
                    //useBattery(GameSettings.stepSize, this.rain);
                    updateDistanceTraveled(GameSettings.stepSize);
                    Render.drawTowTruck(map, gr, this.batteryCharge);
                    this.lastx = cor[0];
                    this.lasty = cor[1];
                }
                }
        } else if(d3 < d1 && d3 < d2 &&d3 < d4){
            for(int[] cor : shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[2])){
                lastCords[0] = this.lastx;
                lastCords[1] = this.lasty;
    
                if(cor[0] == this.lastx && cor[1] == this.lasty){
                    this.lastx = cor[0];
                    this.lasty = cor[1];
                } else {
                    map.movePlayer(cor, lastCords);
                    //useBattery(GameSettings.stepSize, this.rain);
                    updateDistanceTraveled(GameSettings.stepSize);
                    Render.drawTowTruck(map, gr, this.batteryCharge);
                    this.lastx = cor[0];
                    this.lasty = cor[1];
                }
                }
        } else if(d4 < d2 && d4 < d3 &&d4 < d1){
            for(int[] cor : shortestPathBetweenPoints.findShortestPath(map.paths, lastLocation , map.chargePoint[3])){
                lastCords[0] = this.lastx;
                lastCords[1] = this.lasty;
    
                if(cor[0] == this.lastx && cor[1] == this.lasty){
                    this.lastx = cor[0];
                    this.lasty = cor[1];
                } else {
                    map.movePlayer(cor, lastCords);
                    //useBattery(GameSettings.stepSize, this.rain);
                    updateDistanceTraveled(GameSettings.stepSize);
                    Render.drawTowTruck(map, gr, this.batteryCharge);
                    this.lastx = cor[0];
                    this.lasty = cor[1];
                }
                }
        } else {
            System.out.println("TowTruck Broke");
        } 
    chargeBattery(false);
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
                if(batteryCharge <= 0){
                    break;
                }
            }
        }
        
        if(batteryCharge <= 0){
            callTowTruck();
        }
        //manageLocations();
    }

    public void manageLocations(){
        Scanner sc = new Scanner(System.in);
        String coor = ch.getLetter(lastx) + Integer.toString(lasty + 1);
        boolean answer = false;
        while(!answer){
            if(ch.isCheckPoint(coor)){
                gr.energyBar(this.batteryCharge);

                boolean has = updateAnswered(lastx, lasty);

                if(!has){
                    System.out.println("Location: " + ch.checkpointsInAMap().get(coor).get("name"));
                    System.out.println(ch.checkpointsInAMap().get(coor).get("task"));
                    String user_answer = sc.nextLine();
                    ArrayList<String> arr = new ArrayList<>(Arrays.asList(ch.checkpointsInAMap().get(coor).get("answer").split(", ")));
                    if(!arr.contains(user_answer.toUpperCase())){
                        System.out.println("Wrong answer... Try again!");
                        answer = false;
                    }else{
                        System.out.println("\nCorrect! Good job!\n");
                        //updateAnswered(lastx, lasty);
                        answer = true; break;
                    }
                }else if(ch.isChargeStation(coor)){

                    System.out.println("Location: " + ch.chargeStationsInAMap().get(coor).get("name"));
                    if(ch.chargeStationsInAMap().get(coor).get("name") == "SuperCharge"){
                        chargeBattery(true);
                        gr.energyBar(this.batteryCharge);
                        answer = true; break;
                    }else{
                        chargeBattery(false);
                        gr.energyBar(this.batteryCharge);
                        answer = true; break;
                    }
                }if(has){break;}
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
