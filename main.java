public class main {
    public static void main(String[] args){
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        m.initMap();
        GameRender.renderMap(GameMap.map);
}
    
}