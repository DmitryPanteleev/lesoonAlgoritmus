import java.lang.reflect.Array;

/*
        Пантелеев Дмитрий
*/
public class lesson2 {

    private static int resultRec2 = 1;
    private static int resultRec = 0;
    private static int resultDegree = 1;
    private static int resultfun = 0;
    private static double count = 0;
    private static int resultCount = 0;

    public static void main(String[] args) {
//        1. Реализовать функцию перевода чисел из десятичной системы в двоичную, используя
//           рекурсию.
        funDecInBin(123);


//        2. Реализовать функцию возведения числа a в степень b:
        rec2(5, 11);//чётность и рекурсия
        rec(5, 11);//рекурсия
        degree(5, 11);//степень

//        3. Исполнитель Калькулятор преобразует целое число, записанное на экране.
//           У исполнителя две команды, каждой команде присвоен номер:
//           Прибавь 1
//           2.Умножь на 2
//           Первая команда увеличивает число на экране на 1,
//           вторая увеличивает это число в 2 раза.
//           Сколько существует программ, которые число 3 преобразуют в число 20?
//           а) с использованием массива;
//           б) с использованием рекурсии.

//        calcMass();
        calcRec(3, 20, 1, 2);


//        int move = 1;
//        int[] array = new int[100];
//        while (move < 21) {
//            array[move] = move+2;
//            move++;
//        }

        System.out.println("Результат цикла: " + resultDegree);
        System.out.println("Результат рекурсии: " + resultRec);
        System.out.println("Результат рекурсии учитывая свойство чётности степени: " + resultRec2);
        System.out.println("Результат бинаризации: " + resultfun);


    }

    //  3. Исполнитель Калькулятор преобразует целое число, записанное на экране.
    private static int calcRec(int start, int end, int sum, int mult) {
        if (start == end) {
            return 1;
        } else if (start % 2 == 0) {
            calcRec(start += (start - sum) + (start / mult), end, sum, mult);
        } else {
            calcRec(start += (start - sum), end, sum, mult);
        }


        return end;
    }

//    private static int calcMass() {
//
//        Array[] calcMassArr = new Array[];
//
//    }

    //  1. Реализовать функцию перевода чисел из десятичной системы в двоичную,
    //  используя рекурсию.
    private static int funDecInBin(int ten) {
        if (ten == 0) {
            return 1;
        }
        resultfun = (int) (resultfun + (ten % 2) * (Math.pow(10, count)));
        count++;

        funDecInBin(ten /= 2);

        return resultfun;
    }

    //2. Реализовать функцию возведения числа a в степень b:
    //   c. *Рекурсивно, используя свойство чётности степени
    private static int rec2(int dec, int pow) {
//        if (resultRec2 == 0){resultRec2 = dec;}
        if (pow == 0) return 1;
        if (pow % 2 != 0) {
            resultRec2 *= dec;
            --pow;
        }
        rec2(dec *= dec, pow /= 2);

        return resultRec2;
    }

    //    b. Рекурсивно.
    private static int rec(int dec, int pow) {
        if (resultRec == 0) {
            resultRec = dec;
        }
        if (pow == 1) {
            return resultRec;
        }

        return resultRec *= rec(dec, --pow);

    }

    //    a. Без рекурсии.
    private static int degree(int dec, int pow) {

        while (pow > 0) {
            resultDegree *= dec;
            pow--;
        }
        return resultDegree;
    }
}
