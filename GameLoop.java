public class GameLoop {
    public static void initGame(PlayerInfo player){
        CLIUtils.ClearConsole();
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        GameRender gr = new GameRender(player);
        m.initMap(0,0);
        Graphics.banner();
        GameRender.renderMap(GameMap.map);
        Graphics.energyBar(player.battery);
        gr.gamePlay();
    }
}
