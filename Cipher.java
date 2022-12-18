import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Cipher {
    public final char[] alph="абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,””:-! ?".toCharArray();
    private int key;
    public Cipher(){

    }
    public void setKey(int val){
        this.key=val;
    }

    public int getKey() {
        return key;
    }

    public void Encrypt(String filePath, int key) throws IOException {
        try(FileReader in = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(in);
            FileWriter out = new FileWriter("encryptResult.txt"))
        {
            while (reader.ready()) {
                for (char symbol : reader.readLine().toCharArray()) {
                    for (int j = 0; j < alph.length; j++) {
                        if (symbol == alph[j]) {
                            char c= alph[(j+key)%alph.length];
                            out.append(c);
                        }
                    }
                }
            }
        }
    }
}
