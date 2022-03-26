public class Render {
    public static void drawMap(char[][] playerLocation, WorldMap map){
        for(int y = 0; y < map.height; y++){
            for(int x = 0; x < map.width; x++){
                if(x == cords[0] && y == cords[1]){

                }
                map[x][y] = '-';
            }
        }
        
        return;
    }
}
