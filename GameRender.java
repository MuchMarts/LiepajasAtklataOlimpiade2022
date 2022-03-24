import java.util.Scanner;

public class GameRender { 

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

    public static void gamePlay(){
        //TODO: add checkpoints and gameplay and such?
        MovingAround ma = new MovingAround();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i<4){
            ma.scanning();
            renderMap(GameMap.map);
            i++;
        }
        sc.close();
        System.out.println("Paldies par speeli <3");
    }
}
