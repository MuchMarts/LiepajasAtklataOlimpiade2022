import java.util.Scanner;

public class StartScreen {

    public static void IntroAnimation(){
        System.out.println("\n\n\n");
        Graphics.renderGraphics(Graphics.gameCreators());
        System.out.println("\n\n\n");
        CLIUtils.wait(CLIUtils.sec(4));
        CLIUtils.ClearConsole();

        System.out.println("\n\n");
        Graphics.renderGraphics(Graphics.banner());
        System.out.println("\n");
    }

    public static void banner(){
        System.out.println("\n\n");
        Graphics.renderGraphics(Graphics.banner());
        System.out.println("\n");
    }

    public static Integer validChoice(){
        boolean isNotValid = true;
        while(isNotValid){
            int x = gameOptions();
            switch(x){
                case 0: break;
                case 1: isNotValid = false;
                case 2: isNotValid = false;
                case 3: isNotValid = false;
                case 4: isNotValid = false;
                case 5: isNotValid = false;
            }
            if(!isNotValid){
                return x;
            }
            CLIUtils.wait(50);
        }
        return -1;
    }

    public static Integer gameOptions(){
        Scanner sc = new Scanner(System.in);

        int state = 0; // determines game state
        // 0 means something went wrong

        CLIUtils.ClearConsole();

        banner();

        System.out.println("[1] Start game");
        System.out.println("[2] Leaderboard");
        System.out.println("[3] Task editor");
        System.out.println("[4] Map editor");
        System.out.println("[5] Exit");      

        System.out.println("\nIzvēlaties opciju: ");
        
        if(sc.hasNextInt()){
            int x = sc.nextInt();
            if(x >= 1 && x <=5){
                state = x;
            } else {
                CLIUtils.ClearConsole();
                System.out.println("Option does not exists");
                CLIUtils.wait(CLIUtils.sec(1));
            }
        }
        else{
            CLIUtils.ClearConsole();
            System.out.println("Invalid input needs to be int 1-5... Try again.");
            CLIUtils.wait(CLIUtils.sec(1));
        }
        return state;
    }
}