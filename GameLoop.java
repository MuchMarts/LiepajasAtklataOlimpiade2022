public class GameLoop {
    public static void initGame(PlayerInfo player){
        CLIUtils.ClearConsole();
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        GameRender gr = new GameRender(player);
        Graphics g = new Graphics();
        m.initMap(0,0);
        g.banner();
        GameRender.renderMap(GameMap.map);
        g.energyBar(player.battery);
        gr.gamePlay();
    }
}
