import java.util.Scanner;

public class Graphics {
    Scanner sc = new Scanner(System.in);

    private String[] Banner(){
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

    private String[] gameCreators(){
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
