public class PlayerOne {
    char[][] playerVision;
    public void player(){
        playerVision = new char[GameTuning.pxy][GameTuning.pxy];
        
        //init Player vision set all values to null
        for(int x = 0; x < GameTuning.pxy; x++){
            for(int y = 0; x < GameTuning.pxy; y++){
                playerVision[x][y] = '-';
            }
        }
    }

    private boolean isValid(int ca, int a, int max){
        if(a+ca >=0|| a+ca<max){
            return true;
        } else {
            return false;
        }
    }

    //helper functions to change plyer vision values
    private void updateHelper(int x, int y, char value){
        playerVision[x + GameTuning.visionRad][y + GameTuning.visionRad] = value;
    }


    //Updates player vision map from current coords
    public void updateVision(int cx, int cy, char[][] map){ 
        for(int x = (0 - GameTuning.visionRad); x <= GameTuning.visionRad; x++){
            for(int y = (0 - GameTuning.visionRad); y <= GameTuning.visionRad; y++){
                if(isValid(cy, y, map[x].length) && isValid(cx, x, map.length)){ //checks if x and y arent out of bounds
                    updateHelper(x, y, map[cx + x][cy + y]);
                } else {
                    updateHelper(x, y, '-');
                }
            }
         }
    }

}
