import java.util.Scanner;

public class GameRender { 

    public static void renderMap(char[][] map){
    //prints out the map along with letter and number identificators
        for(int y = 0; y < GameTuning.h; y++){
            if(y<10 && y!=0){
                System.out.print(" " + y + " ");
            }else if(y==0){
                System.out.print("   ");
            }else{
                System.out.print(y + " ");
            }
            for(int x = 0; x < GameTuning.w; x++){
                if(y==0){
                    System.out.print((char)(x + 17 + '0') + " ");
                }else{
                    System.out.print(map[x][y] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void gamePlay(){
        //TODO: add checkpoints and gameplay and such?
        MovingAround ma = new MovingAround();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i<4){
            renderMap(ma.moving());
            i++;
        }
        sc.close();
        System.out.println("Paldies par speeli <3");
    }
}
