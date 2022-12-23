import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cipher cipher=new Cipher();
        BruteForce bruteForce=new BruteForce();
        Scanner sc=new Scanner(System.in);
        int menu = 0;
        while (menu!=4){
            System.out.println("Выберите функцию:");
            System.out.println("1. Зашифровать текст");
            System.out.println("2. Расшифровать текст");
            System.out.println("3. Brute force");
            System.out.println("4. Выход из программы");
            menu = sc.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Введите путь к файлу:");
                    sc.nextLine();
                    String path= sc.nextLine();
                    System.out.println("Введите ключ:");
                    int key = sc.nextInt();
                    try {
                        cipher.encrypt(path,key);
                        System.out.println("Результат записан в encryptResult.txt\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("Введите путь к файлу:");
                    sc.nextLine();
                    String path2= sc.nextLine();
                    System.out.println("Введите ключ:");
                    int key2 = sc.nextInt();
                    try {
                        cipher.decrypt(path2,key2);
                        System.out.println("Результат записан в decryptResult.txt\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println("Введите путь к файлу:");
                    sc.nextLine();
                    String path3= sc.nextLine();
                    try {
                        System.out.println("Ключ = "+bruteForce.findKey(path3));

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Выберите пункт из меню!");
                    System.out.println();
                    break;
            }
        }




    }
}
