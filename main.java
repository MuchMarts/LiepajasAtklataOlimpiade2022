public class main {
    public static void main(String[] args){
       World w = new World(10, 10, 1); // creates 10x10 map, player vision raduys 1 => player vision 3x3
       w.updatePlayerVision(0, 0); // Update player vision/ need to be called every time a move is made.
       //w.player_vision <= player vision
    }
}