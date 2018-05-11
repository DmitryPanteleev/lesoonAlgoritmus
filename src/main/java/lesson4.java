import java.util.Scanner;

//Дмитрий Пантелеев

public class lesson4 {
    static String string;

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
            if (i < string.length()) {
                if (out1 > in1) {
                    out1--;
                    System.out.println("Ошибка: " + string.substring(0, i - 1) + " !>" + charr + "<! " + string.substring(i));
                } else if (out2 > in2) {
                    out2--;
                    System.out.println("Ошибка: " + string.substring(0, i - 1) + " !>" + charr + "<! " + string.substring(i));
                } else if (out3 > in3) {
                    out3--;
                    System.out.println("Ошибка: " + string.substring(0, i - 1) + " !>" + charr + "<! " + string.substring(i));
                } else
                    if ((string.charAt(i) == ')' || string.charAt(i) == '[' || string.charAt(i) == '{')
                        && (charr == ')' || charr == ']' || charr == '}')) {
                    System.out.println("Ошибка: " + string.substring(0, i - 1) + " !>" + charr + "<! " + string.substring(i));
                }
            }
        }
        System.out.println(string.length());

    }

}
