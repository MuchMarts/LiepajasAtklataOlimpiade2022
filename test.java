import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("Graphics.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray banner = (JSONArray) jsonObject.get("banner");
            
            Iterator it = banner.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
             
            //Iterate over employee array
            //employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPathException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("ooo poopy");
            e.printStackTrace();
        }
    }
}
