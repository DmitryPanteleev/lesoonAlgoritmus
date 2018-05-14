package lesson6;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lesson6 {
    static int[] tree = new int[10];
    static int[] temp = new int[tree.length];
    static int root = 1;
    static Object[] students = new Object[10];

    //    static int i = 1;
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

//Массив для деревьев***************************
/*        for (int i = 1; i < tree.length; i++) {

            temp[i] = i;
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
        System.out.println();
*/
//**********************************************

// *******Создание массива студентов************

        ArrayStudents arrayStudents = new ArrayStudents();
        Student student1 = new Student("q","a",1,1,2001,1);
        Student student2 = new Student("w","s",2,2,2002,2);
        Student student3 = new Student("e","d",3,3,2003,3);
        Student student4 = new Student("r","f",4,4,2004,4);
        Student student5 = new Student("t","g",5,5,2005,5);
        Student student6 = new Student("y","h",6,6,2006,6);
        arrayStudents.addStudentToArray(student1);
        arrayStudents.addStudentToArray(student2);
        arrayStudents.addStudentToArray(student3);
        arrayStudents.addStudentToArray(student4);
        arrayStudents.addStudentToArray(student5);
        arrayStudents.addStudentToArray(student6);
        arrayStudents.deleteStudent("w","s");
        for (Student student:
             arrayStudents.getArray()) {
            System.out.println(student);
        }


//**********************************************

//        while (true) {
//        System.out.println("Введи строку из чисел и английского алфавита, нижнего регистра");
//        System.out.println("Хэш сумма: " + hashFunktion(scanner.nextLine()));
//        }
//        System.out.println(hashFunktion("123qwe"));
//        System.out.print("Введите метод поиска числа:" +
//                '\n' + "1: двоичный поиск по дереву (центр, левый, правый.)," +
//                '\n' + "2: двоичный поиск по дереву (левый, центр, правый.)," +
//                '\n' + "3: двоичный поиск по дереву (правый, центр, левый)" + '\n');
////        System.out.println("Введите искомое число от 1 до 10 " + );
//        int temp = scanner.nextInt();
//        if (temp == 1) {
//        doubleTreeSearch("5", 1);
//        } else if (temp == 2) {
//            doubleTreeSearchLeft();
//        }


//      Должен найти
//        doubleTree("5");
//        doubleTreeSearch("5", root);

//      Заведомо ложные данные
//        doubleTree("50");

    }
//******Таблица студентов********************************




//******Развлечения с деревьями (через массив)**************************

//    Распечатываем массив
    private static void printArray() {
        for (int j = 0; j < temp.length; j++) {

            System.out.print(tree[j] + " ");
        }
        System.out.println();
    }

//    Обходим дерево рекурсивно
    private static int doubleTreeSearch(int search, int root) {
        if (tree[root] == search) {
            System.out.println("Число " + tree[root] + " найдено в ячейке: " + root);
            return tree[root];
        } else if ((2 * root + 1) < tree.length) {
                if (doubleTreeSearch(search, 2 * root) != 0) {
                    doubleTreeSearch(search, 2 * root + 1);
                }
            }
        return 0;
    }

// Обходим все поля дерева при помощи цикла, не самый лучший способ, но работает.
    private static void doubleTree(int search) {

        boolean flag = false;
        while (2 * root < tree.length) {
            if (tree[root] == search) {
                System.out.println("Алгоритм нашёл число " + tree[root] + " в ячейке " + (root));
                flag = true;
                root++;
            } else if (tree[2 * root] == search) {
                System.out.println("Алгоритм нашёл число " + tree[2 * root] + " в ячейке " + (2 * root));
                flag = true;
                root++;
            } else if (tree[2 * root + 1] == search) {
                System.out.println("Алгоритм нашёл число " + tree[2 * root + 1] + " в ячейке " + (2 * root + 1));
                flag = true;
                root++;
            } else root++;
        }
        if (flag == false) {
            System.out.println("Число " + search + " не найдено");
        }
        System.out.println();
        root = 1;

    }

//******хэш функция***************************************
    private static int hashFunktion(String string) {

        char[] stringHash = new char[string.length() + 5];
        int[] intHash = new int[stringHash.length + 5];

        int sum = string.length();
        int i = 0;
        Pattern p = Pattern.compile("[0-9]");

        while (i < string.length()) {
            Matcher matcher = p.matcher(string.substring(i, i + 1));
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
                sum += 3;
                sum *= 365;

                i--;
            }
            i++;
        }
        return sum;

    }

}

