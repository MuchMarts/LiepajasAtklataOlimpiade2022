import java.util.HashMap;
import java.util.Map;

public class Translate {

    private Map<Integer, Character> alphabet;

    public Translate(){
        alphabet = new HashMap<>();
        for(int i = 0; i < 26; i++){ 
            //creates a map where every letter of the alphabet has an according integer(1-26)
            alphabet.put(i, (char)(i + 17 + '0'));
        }
    }

    public int getInteger(String letter){
        int i = 0;
        while(alphabet.get(i) != letter.charAt(0)){
            i++;
        }
        return i;
    }

    public char getLetter(int number){
        return alphabet.get(number);
    }
}
