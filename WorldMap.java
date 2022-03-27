public class WorldMap {
    
    public char[][] gameMap;
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

    }
}
