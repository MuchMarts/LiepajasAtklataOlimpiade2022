public class main {
    public static void main(String[] args){
        
        CLIUtils.ClearConsole();

        PlayerInfo player = new PlayerInfo("Banana Man1");

        StartScreen.IntroAnimation();
        int choice = StartScreen.validChoice();
        switch(choice){ //TODO: This needs to be recursive => move to Start screen or a game options class and make a method thats recursive
            case -1: System.out.println("Error");
            case 1:
                GameLoop.initGame(player); 
                break; //start game
            case 2: break; //leaderboard
            case 3: break; //edit tasks
            case 4: break; // edit map
            case 5: CLIUtils.exitGame();
        }
        /*
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        GameRender gr = new GameRender();
        m.initMap(0,0);
        GameRender.renderMap(GameMap.map);
        gr.gamePlay();
        */
}
    
}