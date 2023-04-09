import java.io.*;

public class Cipher {
    private final char[] alph = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,””:-! ?".toCharArray();

    public void encrypt(String filePath, int key) throws IOException {
        if (key > 0) {
            try (FileReader in = new FileReader(filePath);
                 BufferedReader reader = new BufferedReader(in);
                 FileWriter out = new FileWriter("encryptResult.txt");
                 BufferedWriter writer = new BufferedWriter(out)
            ) {
                while (reader.ready()) {
                    for (char symbol : reader.readLine().toCharArray()) {
                        writer.append(chekAlphEncrypt(symbol, key));
                    }
                    writer.append('\n');
                }
                writer.flush();
            }
        } else {
            System.out.println("Ключ должен быть больше 0!");
        }
    }

    private char chekAlphEncrypt(char symbol, int key) {
        for (int j = 0; j < alph.length; j++) {
            if (symbol == alph[j]) {
                return alph[(j + key) % alph.length];
            }
        }
        return symbol;
    }

    public void decrypt(String filePath, int key) throws IOException {
        if (key > 0) {
            try (FileReader in = new FileReader(filePath);
                 BufferedReader reader = new BufferedReader(in);
                 FileWriter out = new FileWriter("decryptResult.txt");
                 BufferedWriter writer = new BufferedWriter(out)) {
                while (reader.ready()) {
                    for (char symbol : reader.readLine().toCharArray()) {
                        writer.append(chekAlphDecrypt(symbol, key));
                    }
                    writer.append('\n');
                }
                writer.flush();
            }
        } else {
            System.out.println("Ключ должен быть больше 0!");
        }
    }

    private char chekAlphDecrypt(char symbol, int key) {
        char c;
        for (int j = 0; j < alph.length; j++) {
            if (symbol == alph[j]) {
                int index = (j - key) % alph.length;
                if (index < 0) {
                    c = alph[alph.length + index];
                } else {
                    c = alph[index];
                }
                return c;
            }
        }
        return symbol;
    }
}
