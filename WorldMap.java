public class WorldMap {
    
    //Stores Player location and World map

    public char[][] gameMap;
    public char[][] playerLocation;
    public int[][] paths;
    public int width;
    public int height;
    public int[] playerLastCordinates;
    Player player;

    public WorldMap(int w, int h){
        this.width = w;
        this.height = h;
        this.playerLastCordinates = new int[2];
        this.playerLastCordinates[0] = GameSettings.start_x;
        this.playerLastCordinates[1] = GameSettings.start_y;
        this.player = player;

        initMap();

    }

    private void initMap(){
        this.gameMap = new char[this.width][this.height];
        //TODO: Read map info from somewhere

        //Intializes map data (RN TEMP FILLED WITH -)
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                this.gameMap[x][y] = '-';
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
        this.paths = new int[this.width][this.height]; 
        //Init Path map
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                if(gameMap[x][y] == '=' || gameMap[x][y] == '@' || gameMap[x][y] == '$'){
                    paths[y][x] = 1;
                } else {
                    paths[y][x] = 0;
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
