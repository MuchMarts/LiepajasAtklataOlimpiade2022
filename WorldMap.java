import java.util.ArrayList;
import java.util.Arrays;

public class WorldMap {
    
    //Stores Player location and World map

    public char[][] gameMap;
    public char[][] playerLocation;
    public int[][] paths;
    public int width;
    public int height;
    public int[] playerLastCordinates;
    CheckpointParser ch;
    Translate translate;


    public WorldMap(int w, int h, CheckpointParser ch){
        this.width = w;
        this.height = h;
        this.playerLastCordinates = new int[2];
        this.playerLastCordinates[0] = GameSettings.start_x;
        this.playerLastCordinates[1] = GameSettings.start_y;
        this.ch = new CheckpointParser();
        this.translate = new Translate();
        //checkJson();
        //CLIUtils.wait(CLIUtils.sec(10));
        //genPaths();
        initMap();

    }
    /*private void checkJson(){
        String roadcoor;
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                roadcoor = ch.getLetter(x) + Integer.toString(y + 1);
                if(ch.isCheckPoint(roadcoor)){
                    System.out.println(ch.checkpointsInAMap().get(roadcoor));
                }
            }}
    }
*/
/*    
private void genPaths(){
        
        this.paths = new int[this.width][this.height]; 

        int[][] temp_paths = new int[this.width][this.height]; 
        
        for(int ty = 0; ty < this.height; ty++){
            for(int tx = 0; tx < this.width; tx++){
                temp_paths[ty][tx] = 1;
            }   
        }

        String roadcoor;
        
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){

                roadcoor = ch.getLetter(x) + Integer.toString(y + 1);
                if(ch.isCheckPoint(roadcoor)){
                    int[] point = {y, x};

                    ArrayList<String> allNodes = new ArrayList<>(Arrays.asList(ch.checkpointsInAMap().get(roadcoor).get("nodes").split(" ")));
                    
                    for(String end : allNodes){
                        if(end == ""){
                            this.paths[point[1]][point[0]] = 1;
                            break
                            ;}

                        int xCor = Integer.parseInt(end.substring(1));
                        int yCor = translate.getInteger(end.substring(0,1).toUpperCase());

                        int[] cord = {yCor - 1, xCor};
                        int[][] road = shortestPathBetweenPoints.findShortestPath(temp_paths, point, cord);

                        setRoad(road);
                    }
                } 
            }
        }   
    }

    private void setRoad(int[][] roads){
        for(int[] xy : roads){
            this.paths[xy[1]][xy[0]] = 1;
        }
    }
*/
    private void initMap(){
        this.paths = new int[this.width][this.height];
        this.gameMap = new char[this.width][this.height];
        //TODO: Read map info from somewhere
        //Intializes map data (RN TEMP FILLED WITH -)

        int[][] hardCodedPaths = {
            {0,0},
            {1,1},
            {1,2},
            {1,3},
            {1,4},
            {2,5},
            {2,6},
            {3,7},
            {4,8},
            {4,9},
            {5,10},
            {2,11},
            {3,11},
            {4,11},
            {1,12},
            {6,11},
            {7,11},
            {8,11},
            {9,11},
            {10,11},
            {11,12},
            {11,13},
            {4,6},
            {4,5},
            {5,6},
            {6,5},
            {6,4},
            {5,3},
            {6,2},
            {2,2},
            {3,2},
            {4,2},
            {7,1},
            {8,1},
            {9,2},
            {9,3},
            {10,4},
            {10,5},
            {10,6},
            {10,7},
            {9,8},
            {11,6},
            {12,6},
            {13,6},
        };
        
        for(int[] roadCord : hardCodedPaths){
            this.paths[roadCord[0]][roadCord[1]] =1;
        }

        //Fill map with path data
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                if(this.paths[y][x] == 1){
                    this.gameMap[x][y] = '=';
                } else {
                    this.gameMap[x][y] = '-';
                }
                }
            }

        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                String coor = ch.getLetter(x) + Integer.toString(y + 1);
                if(ch.isCheckPoint(coor)){
                    this.gameMap[x][y] = '@';
                } else if(ch.isChargeStation(coor)){
                    this.gameMap[x][y] = '$';
                 }
            }
        }

        this.playerLocation = new char[this.width][this.height]; 
        //Init player location
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                if(x == GameSettings.start_x && y == GameSettings.start_y){
                    this.playerLocation[x][y] = 'X';
                }
                }
            }
    }

    //Updates player location
    public void movePlayer(int[] playerCordinates, int[] lastCordinates) {
        
        int x = playerCordinates[0];
        int y = playerCordinates[1];

        playerLocation[lastCordinates[0]][lastCordinates[1]] = ' ';
        playerLocation[x][y] = 'X';

    }
}
