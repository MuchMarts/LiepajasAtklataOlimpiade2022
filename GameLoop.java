public class GameLoop {
    public static void initGame(){
        CLIUtils.ClearConsole();
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        GameRender gr = new GameRender();
        m.initMap(0,0);
        StartScreen.banner();
        GameRender.renderMap(GameMap.map);
        gr.gamePlay();
    }
}
