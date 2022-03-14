public class Rederer{
    
    HashMap<String, char> dictionary; // Stores values of each possible state for 2d array map
    HashMap<char, String[]> graphics; // Stores String[] of ascii art for each possible state

    public static void Renderer(String[] args) {
        init_dictionary();
        init_graphics();
    }

    private void init_dictionary(){
        dictionary = new HashMap<String, char>();

    }

    private void init_graphics(){
        graphics = new HashMap<char, String[]>();
    
    }

    public char getItem(String key){
        char state = dictionary.get(key);
        if(state != null){
            return state;
        } else {
            System.out.printl("Error no such key found");
            return 0;
        }
    }

    private String[] get_graphics(char key){
        char value = graphics.get(key);
        if(value != null){
            return value;
        } else {
            System.out.printl("Error no such key found");
        }
    }

    public void drawGraphics(String[][] map, int size){
    }
    
}