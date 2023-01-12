import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce {
    //алфавит часто дублируется, его стоит вынести в отдельный класс и оттуда его брать
    public final char[] alphLow="абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    public final char[] alphUp="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    public final char[] alph=".,””:-! ?".toCharArray();

    //поле ниже стоит сделать final(это же и советует идейка, если навести и клацнуть мышкой - она сама все сделает)
    private ArrayList<String> words=new ArrayList<>(Arrays.asList("я ","ты ","он ","она ","они ","это ", "то ", "эти ", "те ", "мы ", "вы ",
            "что ", "но ", "как ", "как-то ", "как-нибудь ", "да ", "нет ", "никак ", "где ", "когда ", "почему ", "зачем "));
    private ArrayList<Character> charsFromFile=new ArrayList<>();
    private Cipher cipher=new Cipher();
    private int key=0;
    public int findKey(String filePath) throws IOException {
        while (!checkRules()) {
            key++;
            cipher.decrypt(filePath, key);
            readFile("decryptResult.txt");//аргумент всегда один и тот же - в нем нет смысла, это значение надо тогда засунуть в функцию
        }
        return key;
    }
    private void readFile(String filePath){
        charsFromFile.clear();
        try (FileReader in = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(in)) {
            while (reader.ready()) {
                for (char symbol : reader.readLine().toCharArray()) {
                    charsFromFile.add(symbol);
                }
                charsFromFile.add('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean checkWords(String str){
        for (String s:words) {
            if(str.toLowerCase().contains(s)){
                return true;
            }
        }
        return false;
    }
    private boolean checkRules(){
        char[] result = new char[charsFromFile.size()];
        int i = 0;
        for (Character character : charsFromFile) {
            result[i] = character;
            i++;
        }
        String str = new String(result);
        return str.contains(". ") || str.contains(", ") || str.contains("  ") || checkWords(str);//так выглядит изящней
    }

}
