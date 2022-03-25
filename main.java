public class main {
    public static void main(String[] args){
        
        CLIUtils.ClearConsole();

        StartScreen.IntroAnimation();
        int choice = StartScreen.validChoice();
        switch(choice){
            case -1: System.out.println("Error");
            case 1:
                GameLoop.initGame(); 
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