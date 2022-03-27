import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Graphics {
    
    static String[] Banner;
    static String[] GameCreators;

    public Graphics(){
    //reads JSON file with graphics and returns values as JSONArrays
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("Graphics.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray banner = (JSONArray) jsonObject.get("banner");
            Object[] banner_arr = banner.toArray();
            String[] banner_str = new String[banner_arr.length];
            for(int i = 0; i < banner_arr.length; i++){
                banner_str[i] = banner_arr[i].toString();
            }
            Graphics.Banner = banner_str;

            JSONArray creators = (JSONArray) jsonObject.get("creators");
            Object[] creators_arr = creators.toArray();
            String[] creators_str = new String[creators_arr.length];
            for(int i = 0; i < creators_arr.length; i++){
                creators_str[i] = creators_arr[i].toString();
            }
            Graphics.GameCreators = creators_str;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("something went poopy");
        }
    }
    
    public void renderGraphics(String[] graphic){
        for(String line : graphic){
            System.out.println(line);
        }
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

    public void banner(){
        renderGraphics(Banner);
    }

    public void gameCreators(){
        renderGraphics(GameCreators);
    }

    public void energyBar(int x){
        renderGraphics(setEnergy(resolveInt(x)));
    }
}
