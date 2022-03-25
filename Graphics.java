public class Graphics {
    
    //String[] Banner;
    //String[] GameCreators;

    public Graphics(){
    // CODE to read graphics.json values on init replace clunky hardcoded values to just return
    }
    
    public static void renderGraphics(String[] graphic){
        for(String line : graphic){
            System.out.println(line);
        }
    }
    
    /* 
    simple return json stored graphics
    public String[] banner(){
        return this.Banner;
    }
    public String[] gameCreators(){
        return this.GameCreators;
    }
    */
    public static String[] banner(){
        String[] bannerASCII = {
            "  _      _                  _                       _ _ _ _       ___   ___ ___  ___  ",
            " | |    (_)                (_)                     | | (_(_)     |__ \\ / _ |__ \\|__ \\ ",
            " | |     _  ___ _ __   __ _ _  __ _ ___   _ __ __ _| | |_ _ ___     ) | | | | ) |  ) |",
            " | |    | |/ _ | '_ \\ / _` | |/ _` / __| | '__/ _` | | | | / __|   / /| | | |/ /  / / ",
            " | |____| |  __| |_) | (_| | | (_| \\__ \\ | | | (_| | | | | \\__ \\  / /_| |_| / /_ / /_ ",
            " |______|_|\\___| .__/ \\__,_| |\\__,_|___/ |_|  \\__,_|_|_|_| |___/ |____|\\___|____|____|",
            "               | |        _/ |                          _/ |                          ",
            "               |_|       |__/                          |__/                           "
        };
        return bannerASCII;
    }

    public static String[] gameCreators(){
        String[] creatorsASCII = {
            "███    ███  █████  ███████ ██ ██    ██ ██     ███████  █████  ██   ██  █████  ███████      █████  ██████       ██ ",
            "████  ████ ██   ██ ██      ██ ██    ██ ██     ██      ██   ██ ██  ██  ██   ██ ██          ██   ██ ██   ██     ███ ",
            "██ ████ ██ ███████ ███████ ██ ██    ██ ██     ███████ ███████ █████   ███████ ███████     ███████ ██████       ██ ",
            "██  ██  ██ ██   ██      ██ ██  ██  ██  ██          ██ ██   ██ ██  ██  ██   ██      ██     ██   ██ ██   ██      ██ ",
            "██      ██ ██   ██ ███████ ██   ████   ██     ███████ ██   ██ ██   ██ ██   ██ ███████     ██   ██ ██   ██      ██ "
        };
        return creatorsASCII;
    }
}
