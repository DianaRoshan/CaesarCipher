import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce {
    public final char[] alphLow="абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
    public final char[] alphUp="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    public final char[] alph=".,””:-! ?".toCharArray();
    private ArrayList<String> words=new ArrayList<>(Arrays.asList("я ","ты ","он ","она ","они ","это ", "то ", "эти ", "те ", "мы ", "вы ",
            "что ", "но ", "как ", "как-то ", "как-нибудь ", "да ", "нет ", "никак ", "где ", "когда ", "почему ", "зачем "));
    private ArrayList<Character> charsFromFile=new ArrayList<>();
    private Cipher cipher=new Cipher();
    private int key=0;
    public int findKey(String filePath) throws IOException {
        while (!checkRules()) {
            key++;
            cipher.decrypt(filePath, key);
            readFile("decryptResult.txt");
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
        if (str.contains(". ") || str.contains(", ") || str.contains("  ") || checkWords(str)) {
            return true;
        }
        return false;
    }

}
