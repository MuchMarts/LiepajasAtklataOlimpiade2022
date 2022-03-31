public class Render {

    public static void drawMap(WorldMap map, Graphics gr, int battery, boolean rain){
        CLIUtils.ClearConsole();

        gr.banner();

        if(rain){
            System.out.println();
            gr.rainAnimation(); 
            System.out.println();  
        }else{
            System.out.println();
            gr.sunAnimation();
            System.out.println();       
        }

        char[][] currMap = getCurrMapState(map);

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
                switch(currMap[x][y]){
                    case '=' : gr.colourRoad(); break;
                    case '@' : gr.colourCheckPoint(); break;
                    case '$' : gr.colourChargePoint(); break;
                    case '-' : gr.colourEmpty(); break;
                    case 'X' : gr.colourPlayer();break;
                }
            }
            System.out.println();
        }
        
        gr.energyBar(battery);
    }

    public static void drawMapAnim(WorldMap map, Graphics gr, int battery){
        
        char[][] currMap = getCurrMapState(map);

        CLIUtils.ClearConsole();

        gr.banner();

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

        gr.energyBar(battery);

        CLIUtils.wait(1000);
    }

    private static char[][] getCurrMapState(WorldMap map){
        char[][] currentMapState = new char[map.width][map.height];
        
        for(int y = 0; y < map.height; y++){
            for(int x = 0; x < map.width; x++){
                if(map.playerLocation[x][y] == 'X'){
                    currentMapState[x][y] = 'X';
                } else {
                    currentMapState[x][y] = map.gameMap[x][y];
                }
                
            }
        }
        
        return currentMapState;
    }
}
