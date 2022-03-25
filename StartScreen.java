public class StartScreen {

    Graphics gr = new Graphics();

    public StartScreen(){
        System.out.println("\n\n\n");
        gr.renderGraphics(gr.gameCreators());
        System.out.println("\n\n\n");
        CLIUtils.wait(CLIUtils.sec(4));
        CLIUtils.ClearConsole();

        System.out.println("\n\n");
        gr.renderGraphics(gr.banner());
        System.out.println("\n");
    }
}