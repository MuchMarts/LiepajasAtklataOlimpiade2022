public class GameMap {

        static char[][] map;
        private int width;
        private int height;
    
        public GameMap(int width, int height) {
            this.width = width;
            this.height = height;
        }
        
        public void initMap(int x, int y) {
            map = new char[width][height];
            GameRender gr = new GameRender();
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
    

