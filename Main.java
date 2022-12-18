import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cipher cipher=new Cipher();

        Scanner sc=new Scanner(System.in);
        System.out.println("Выберите функцию:");
        int menu = 0;
        while (menu!=4){
            System.out.println("1. Зашифровать текст");
            System.out.println("2. Расшифровать текст");
            System.out.println("3. Brute force");
            System.out.println("4. Выход из программы");
            menu = sc.nextInt();
            switch (menu){
                case 1:
                    System.out.println("Введите название файла:");
                    String path= sc.nextLine();
                    System.out.println("Введите ключ:");
                    int key = sc.nextInt();
                    try {
                        cipher.Encrypt(path,key);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2: break;
                case 3: break;
                default:break;
            }
        }





    }
}
