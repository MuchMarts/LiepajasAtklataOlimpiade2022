import java.util.HashMap;

public class WorldMap {
    
    //Stores Player location and World map

    public char[][] gameMap;
    public char[][] playerLocation;
    public int width;
    public int height;

    public WorldMap(int w, int h){
        this.width = w;
        this.height = h;

        initMap();

    }

    private void initMap(){
        this.gameMap = new char[this.width][this.height];
        //TODO: Read map info from somewhere
        CheckpointParser ch = new CheckpointParser();
        //Intializes map data (RN TEMP FILLED WITH -)

        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                this.gameMap[x][y] = '-';
                String coor = ch.getLetter(x) + Integer.toString(y + 1);
                if(ch.checkpointsInAMap().containsKey(coor)){
                    this.gameMap[x][y] = '@';
                }else if(ch.chargeStationsInAMap().containsKey(coor)){
                    this.gameMap[x][y] = '$';
                }
            }
        }

        //checkpoints.forEach();

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
    public int[] movePlayer(int[] playerCordinates, int[] lastCordinates) {
        
        int x = playerCordinates[0];
        int y = playerCordinates[1];

        playerLocation[lastCordinates[0]][lastCordinates[1]] = ' ';
        playerLocation[x][y] = 'X';
        
        return playerCordinates; 
    }

}
