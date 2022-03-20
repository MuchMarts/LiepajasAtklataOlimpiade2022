public class main {
    public static void main(String[] args){
        map m = new map(gameSettings.w, gameSettings.h);
        m.initMap();
        render.renderMap(m.map);
}
    
}