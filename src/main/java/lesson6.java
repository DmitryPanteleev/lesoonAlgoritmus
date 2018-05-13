import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lesson6 {
    int hash;

    /**
     * Panteleev Dmitriy
     * <p>
     * 1. Реализовать простейшую хэш-функцию. На вход функции подается строка, на выходе сумма кодов символов.
     * <p>
     * 2. Переписать программу, реализующее двоичное дерево поиска.
     * а) Добавить в него обход дерева различными способами;
     * б) Реализовать поиск в двоичном дереве поиска;
     * в) *Добавить в программу обработку командной строки с помощью которой можно указывать
     * из какого файла считывать данные, каким образом обходить дерево.
     * <p>
     * 3. *Разработать базу данных студентов из двух полей “Имя”, “Возраст”, “Табельный номер”
     * в которой использовать все знания, полученные на уроках.
     * Считайте данные в двоичное дерево поиска. Реализуйте поиск по какому-нибудь полю базы данных (возраст, вес)
     */



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введи строку из чисел и английского алфавита, нижнего регистра");
            System.out.println("Хэш сумма: "+hashFunktion(scanner.nextLine()));
        }
//        System.out.println(hashFunktion("123qwe"));

    }


    private static int hashFunktion(String string) {

        char[] stringHash = new char[string.length()+5];
        int[] intHash = new int[stringHash.length+5];

        int sum = string.length();
        int i = 0;
        Pattern p = Pattern.compile("[0-9]");

        while (i < string.length()) {
            Matcher matcher = p.matcher(string.substring(i, i+1));
            if (matcher.matches()) {
                switch (string.charAt(i)) {
                    case '1':
                        stringHash[i] = 'h';
                        break;
                    case '2':
                        stringHash[i] = 'a';
                        break;
                    case '3':
                        stringHash[i] = 's';
                        break;
                    case '4':
                        stringHash[i] = 'c';
                        break;
                    case '5':
                        stringHash[i] = 'f';
                        break;
                    case '6':
                        stringHash[i] = 'u';
                        break;
                    case '7':
                        stringHash[i] = 'n';
                        break;
                    case '8':
                        stringHash[i] = 't';
                        break;
                    case '9':
                        stringHash[i] = 'i';
                        break;
                    case '0':
                        stringHash[i] = 'y';
                        break;
                }
            } else {
                stringHash[i] = string.charAt(i);
            }
            i++;
        }

        i = 0;

        while (i < stringHash.length) {
            switch (stringHash[i]) {
                case 'a':
                    intHash[i] = 1;
                    break;
                case 'b':
                    intHash[i] = 2;
                    break;
                case 'c':
                    intHash[i] = 3;
                    break;
                case 'd':
                    intHash[i] = 4;
                    break;
                case 'e':
                    intHash[i] = 5;
                    break;
                case 'f':
                    intHash[i] = 6;
                    break;
                case 'g':
                    intHash[i] = 7;
                    break;
                case 'h':
                    intHash[i] = 8;
                    break;
                case 'i':
                    intHash[i] = 9;
                    break;
                case 'j':
                    intHash[i] = 10;
                    break;
                case 'k':
                    intHash[i] = 11;
                    break;
                case 'l':
                    intHash[i] = 12;
                    break;
                case 'm':
                    intHash[i] = 13;
                    break;
                case 'n':
                    intHash[i] = 14;
                    break;
                case 'o':
                    intHash[i] = 15;
                    break;
                case 'p':
                    intHash[i] = 16;
                    break;
                case 'q':
                    intHash[i] = 17;
                    break;
                case 'r':
                    intHash[i] = 18;
                    break;
                case 's':
                    intHash[i] = 19;
                    break;
                case 't':
                    intHash[i] = 20;
                    break;
                case 'u':
                    intHash[i] = 21;
                    break;
                case 'v':
                    intHash[i] = 22;
                    break;
                case 'w':
                    intHash[i] = 23;
                    break;
                case 'x':
                    intHash[i] = 24;
                    break;
                case 'y':
                    intHash[i] = 25;
                    break;
                case 'z':
                    intHash[i] = 26;
                    break;

            }
            i++;
        }
        i = 0;
        while (i < intHash.length) {
            sum += intHash[i];
            sum *= sum;
//            sum%=intHash[i];
//            sum*=sum;
            if (sum > 100000) {
                sum %= 100000;
            }
            if (sum < 365) {
                sum+=3;
                sum *= 365;

                i--;
            }
            i++;
        }
        return sum;

    }

}

