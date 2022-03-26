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
    private static String[] setBanner(){
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

    private static String[] setGameCreators(){
        String[] creatorsASCII = {
            "███    ███  █████  ███████ ██ ██    ██ ██     ███████  █████  ██   ██  █████  ███████      █████  ██████       ██ ",
            "████  ████ ██   ██ ██      ██ ██    ██ ██     ██      ██   ██ ██  ██  ██   ██ ██          ██   ██ ██   ██     ███ ",
            "██ ████ ██ ███████ ███████ ██ ██    ██ ██     ███████ ███████ █████   ███████ ███████     ███████ ██████       ██ ",
            "██  ██  ██ ██   ██      ██ ██  ██  ██  ██          ██ ██   ██ ██  ██  ██   ██      ██     ██   ██ ██   ██      ██ ",
            "██      ██ ██   ██ ███████ ██   ████   ██     ███████ ██   ██ ██   ██ ██   ██ ███████     ██   ██ ██   ██      ██ "
        };
        return creatorsASCII;
    }

    private static String resolveInt(int x){
        String line = "000";
        if(x == 100){
            line = String.valueOf(x);
        } else if ( x < 100 && x >= 10){
            line = "0" + String.valueOf(x);
        } else if (x < 10 && x >= 0){
            line = "00" + String.valueOf(x);
        } else {
            System.out.println("Something broke lmao ripaks");
        }
        return ("  ###    "+line+"%    ### ");
    }

    private static String[] setEnergy(String xx){
        String[] energyASCII = {
            "\nBattery Charge",
            "[=====================]",
            xx,
            "[=====================]\n"
        };
        return energyASCII;
    }

    public static void banner(){
        renderGraphics(setBanner());
    }

    public static void gameCreators(){
        renderGraphics(setGameCreators());
    }

    public static void energyBar(int x){
        renderGraphics(setEnergy(resolveInt(x)));
    }
}
