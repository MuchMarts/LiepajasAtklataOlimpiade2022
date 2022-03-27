public class GameLoop {
    /*
    public static void initGame(PlayerInfo player){
        CLIUtils.ClearConsole();
        GameMap m = new GameMap(GameSettings.w, GameSettings.h);
        GameRender gr = new GameRender(player);
        m.initMap(0,0);
        Graphics.banner();
        GameRender.renderMap(GameMap.map);
        Graphics.energyBar(player.battery);
        gr.gamePlay();
    }
    */

    public int startGame(Graphics graphics){
        CLIUtils.ClearConsole();

        int start_x = 0;
        int start_y = 0;

        Graphics gr = graphics;
        WorldMap gameMap = new WorldMap(GameSettings.w, GameSettings.h);
        String name = "test"; //TODO: player input name
        Player player = new Player(name, start_x, start_y, gr);

        int i = 0;

        //TODO: ADD INTTRO ANIMATION
        //TODO: Fix no map on start
        //TODO: ADD ENERGY BAR
        while(i<4){
            Render.drawMap(player.playerMove(), gameMap, gr);
            i++;
        }

        return 1;
    }

}
