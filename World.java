public class World{
    public int width;
    public int height;
    public char[][] world_map;      //2d array containing map info
    public char[][] player_vision;  //2d array player visible map info
    public int R;
    
    public World(int x, int y, int vision){
        width = x;
        height = y;
        R = vision;
        world_map = new char[height][width];
        player_vision = new char[R*2+1][R*2+1]
    }
    
    private validCordinate(int x, int y){
        //[TODO]optimize
        if(y < 0 || y > (height - 1)){
            return False;
        }
        if(x < 0 || x > (width - 1)){
            return False;
        }
        return True;
    }

    //cx, cy current player cords
    //Creates array with player seen map tiles
    public updatePlayerVision(int cx, int cy){ 
        for(int y = -R, y <= R, y++){
            for(int x = -R, y <= R, x++){
                if validCordinate(cx + x, cy + y){
                    player_vision[y][x] = world_map[cy + r][cx + x];
                } else {
                    player_vision[y][x] = -1;
                }
            }
        }
    }

}