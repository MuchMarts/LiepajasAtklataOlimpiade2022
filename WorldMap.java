public class WorldMap {
    
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

        //Intializes map data (RN TEMP FILLED WITH -)
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                this.gameMap[x][y] = '-';
            }
        }

        this.playerLocation = new char[this.width][this.height]; 
        
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                if(x == GameSettings.start_x && y == GameSettings.start_y){
                    this.playerLocation[x][y] = 'X';
                } else {
                    this.playerLocation[x][y] = '-';
                }
            }
        }
    }

    public int[] movePlayer(int[] playerCordinates, int[] lastCordinates) {
        
        int x = playerCordinates[0];
        int y = playerCordinates[1];

        playerLocation[x][y] = 'X';
        playerLocation[lastCordinates[0]][lastCordinates[1]] = ' ';
        return playerCordinates; 
    }

}
