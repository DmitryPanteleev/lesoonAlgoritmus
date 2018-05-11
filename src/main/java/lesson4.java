import java.util.Scanner;

//Дмитрий Пантелеев

public class lesson4 {
    static String string;

// Тестовые строки
// 123)(123 123()123 123((123;

    public static void main(String[] args) {


//        3. Написать программу, которая определяет, является ли введенная скобочная последовательность правильной.
//           Примеры правильных скобочных выражений: (), ([])(), {}(), ([{}]),
//           неправильных — )(, ())({), (, ])}), ([(]) для скобок [,(,{.
//           Например: (2+(2*2)) или [2/{5*(4+7)}]

        Scanner in = new Scanner(System.in);
//        string = in.next();
        string = in.nextLine();
        check(string);
        System.out.println(string);

    }

    private static void check(String string) {
        int i = 0;
        int j = 0;
        int in1 = 0; //  '('
        int in2 = 0; // '['
        int in3 = 0; // '{'
        int out1 = 0; // ')'
        int out2 = 0; // ']'
        int out3 = 0; // '}'
        while (i < string.length()) {
            char charr = string.charAt(i);
            //Находим совпадения для сравнения количества открытых и закрытых скобок
            switch (charr) {
                case '(':
                    in1++;
                    i++;
                    break;
                case '[':
                    in2++;
                    i++;
                    break;
                case '{':
                    in3++;
                    i++;
                    break;
                case ')':
                    out1++;
                    i++;
                    break;
                case ']':
                    out2++;
                    i++;
                    break;
                case '}':
                    out3++;
                    i++;
                    break;
                default:
                    i++;
                    break;
            }

            if (out1 > in1) {
                out1--;
                System.out.println("Ошибка: " + string.substring(0, j - 1) + " !>" + charr + "<! " + string.substring(j + 1));
            } else if (out2 > in2) {
                out2--;
                System.out.println("Ошибка: " + string.substring(0, j - 1) + " !>" + charr + "<! " + string.substring(j + 1));
            } else if (out3 > in3) {
                out3--;
                System.out.println("Ошибка: " + string.substring(0, j - 1) + " !>" + charr + "<! " + string.substring(j + 1));
            }
            if (j > 0) {
                if ((string.charAt(j - 1) == '(' || string.charAt(j - 1) == '[' || string.charAt(j - 1) == '{')
                        && (charr == ')' || charr == ']' || charr == '}')) {
                    System.out.println("Ошибка, пустые скобки () : " + string.substring(0, j - 2) + " !>" + string.charAt(j - 1) + charr + "<! " + string.substring(j + 1));
                }
            }
            j++;
        }
        if (out1+out2+out3!=in1+in2+in3){
            System.out.println("Ошибка количества скобок");
        }
    }

}


