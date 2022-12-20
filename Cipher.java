import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Cipher {
    public final char[] alph="абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,””:-! ?".toCharArray();

    public void Encrypt(String filePath, int key) throws IOException {
        if (key>0) {
            try (FileReader in = new FileReader(filePath);
                 BufferedReader reader = new BufferedReader(in);
                 FileWriter out = new FileWriter("encryptResult.txt")) {
                while (reader.ready()) {
                    for (char symbol : reader.readLine().toCharArray()) {
                        out.append(chekAlphEncrypt(symbol, key));
                    }
                    out.append('\n');
                }
                System.out.println("Результат записан в encryptResult.txt\n");
            }
        }else {
            System.out.println("Ключ должен быть больше 0!");
        }
    }
    public char chekAlphEncrypt(char symbol,int key){
        for (int j = 0; j < alph.length; j++) {
            if (symbol == alph[j]) {
                char c= alph[(j+key)%alph.length];
                return c;
            }
        }
        return symbol;
    }

    public void Decrypt(String filePath, int key) throws IOException {
        if(key>0) {
            try (FileReader in = new FileReader(filePath);
                 BufferedReader reader = new BufferedReader(in);
                 FileWriter out = new FileWriter("decryptResult.txt")) {
                while (reader.ready()) {
                    for (char symbol : reader.readLine().toCharArray()) {
                        out.append(chekAlphDecrypt(symbol, key));
                    }
                    out.append('\n');
                }
                System.out.println("Результат записан в decryptResult.txt\n");
            }
        }else {
            System.out.println("Ключ должен быть больше 0!");
        }
    }
    public char chekAlphDecrypt(char symbol,int key){
        char c;
        for (int j = 0; j < alph.length; j++) {
            if (symbol == alph[j]) {
                int index=(j-key)%alph.length;
                if(index<0){
                    c = alph[alph.length+index];
                }else {
                    c = alph[index];
                }
                return c;
            }
        }
        return symbol;
    }
}
