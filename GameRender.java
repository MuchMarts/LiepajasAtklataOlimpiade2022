import java.util.Scanner;

public class GameRender { 

    private static int x;
    private static int y;
    private PlayerInfo player;

    public GameRender(PlayerInfo player){
        this.player = player;
    }

    public void calculateSteps(int cx, int cy){
        int steps = 0;
        if(cx <= x){steps = steps + x - cx;} else {steps = steps + cx - x;};
        if(cy <= y){steps = steps + y - cy;} else {steps = steps + cy - y;};

        player.lastMoveStepCount = steps;
    }

    //This is ehh used in a funky way with moving around and initMap() 
    public static void koord(int vx, int vy){
        //player's current coordinates
        x = vx;
        y = vy;
    }

    public static void renderMap(char[][] map){
    //prints out the map along with letter and number identificators
        System.out.print("   ");
        for(int i = 0; i < GameTuning.w; i++){
            System.out.print((char)(i + 17 + '0') + " ");
        }
        System.out.println();
        for(int y = 0; y < GameTuning.h; y++){
            if(y<9){
                System.out.print(" " + (y + 1) + " ");
            //}else if(y==0){
              //  System.out.print("   ");
            }else{
                System.out.print((y + 1) + " ");
            }
            for(int x = 0; x < GameTuning.w; x++){
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void gamePlay(){
        //TODO: add checkpoints and gameplay and such?
        MovingAround ma = new MovingAround();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i<4){
            ma.scanning(x, y);
            player.drive(lastMoveStepCount); // TODO: Add a way to count how many tiles moved > also mov to moving around 
            CLIUtils.ClearConsole();
            Graphics.banner();
            renderMap(GameMap.map);
            Graphics.energyBar(player.battery);
            i++;
        }
        sc.close();
        System.out.println("Paldies par speeli <3");
    }
}
