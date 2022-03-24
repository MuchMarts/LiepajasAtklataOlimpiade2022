public class main {
    public static void main(String[] args){
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        m.initMap(0,0);
        GameRender.renderMap(GameMap.map);
        GameRender.gamePlay();
}
    
}