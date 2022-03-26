public class GameMap {

        static char[][] map;
        private int width;
        private int height;
    
        public GameMap(int width, int height) {
            this.width = width;
            this.height = height;
        }
        
        //TODO: Maybe store map data in a json or summ cuz how do we draw road where you can drive idfk.

        public void initMap(int x, int y) {
            map = new char[width][height];
                for(int cy = 0; cy < height; cy++){
                    for(int cx = 0; cx < width; cx++){
                    if(cx == x && cy == y){
                        map[cx][cy] = 'X';
                        GameRender.koord(cx, cy + 1);
                    }else{
                        map[cx][cy] = '-';
                    }
                }
            }
        }
    
        
    }
    

