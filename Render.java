public class Render {

    public static void drawMap(char[][] playerLocation, WorldMap map, Graphics gr, int battery){
        
        gr.banner();

        char[][] currMap = getCurrMapState(playerLocation, map);

        System.out.print("   ");
        for(int i = 0; i < GameSettings.w; i++){
            System.out.print((char)(i + 17 + '0') + " ");
        }
        System.out.println();
        for(int y = 0; y < GameSettings.h; y++){
            if(y < 9){
                System.out.print(" " + (y + 1) + " ");
            }else{
                System.out.print((y + 1) + " ");
            }
            for(int x = 0; x < GameSettings.w; x++){
                System.out.print(currMap[x][y] + " ");
            }
            System.out.println();
        }
        
        if(battery == 999){return;}
        gr.energyBar(battery);
    }

    private static char[][] getCurrMapState(char[][] playerLocation, WorldMap map){
        char[][] currentMapState = new char[map.width][map.height];
        
        for(int y = 0; y < map.height; y++){
            for(int x = 0; x < map.width; x++){
                if(playerLocation[x][y] == 'X'){
                    currentMapState[x][y] = 'X';
                } else {
                    currentMapState[x][y] = map.gameMap[x][y];
                }
                
            }
        }
        
        return currentMapState;
    }
}
