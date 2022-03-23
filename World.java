public class World {
    
    GameMap wMap;
    

    public static void world(){
        GameMap wMap = new GameMap(GameTuning.w, GameTuning.h);
        PlayerOne pMap = new PlayerOne();
    }

    public char[][] getMap(){
        return wMap.map;
    }



}
