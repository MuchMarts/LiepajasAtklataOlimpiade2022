public class world {
    
    map wMap;
    

    public static void world(){
        map wMap = new map(gameSettings.w, gameSettings.h);
        player pMap = new player();
    }

    public char[][] getMap(){
        return wMap.map;
    }



}
