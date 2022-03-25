public class main {
    public static void main(String[] args){
        
        CLIUtils.ClearConsole();

        StartScreen sc =  new StartScreen();
        
        
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        GameRender gr = new GameRender();
        m.initMap(0,0);
        GameRender.renderMap(GameMap.map);
        gr.gamePlay();
        
}
    
}