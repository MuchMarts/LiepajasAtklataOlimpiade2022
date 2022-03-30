import java.util.Scanner;

public class PlayerMovement {
    
    Translate translate = new Translate();
    shortestPathBetweenPoints pathFind = new shortestPathBetweenPoints();
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

    private boolean isValidPath(int[] cords){
        if(map.paths[cords[1]][cords[0]] == 0){
            return false;
        }
        return true;
    }

    public boolean checkInputValidity(String input){
        if(input.length() > 1){
            if(translate.getInteger(input.substring(0,1).toUpperCase()) != -1){
                int[] cords = {
                    translate.getInteger(input.substring(0,1).toUpperCase()),
                    translate.getInteger(input.substring(0,1).toUpperCase()) - 1
                };
                if(isValidPath(cords)){                    
                    return true;
                }
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

    public int[][] movePlayer(int[] playerCordinates){        
        if(playerCordinates == null){ System.out.println("Error calculating current coordinates");}
        int[] end = {playerCordinates[1], playerCordinates[0]};
        int[] start = {this.lastXY[1], this.lastXY[0]};        
        int[][] path = shortestPathBetweenPoints.findShortestPath(map.paths, start, end);
        this.lastXY = path[path.length-1]; 
        return path;
    }
}

