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
}
