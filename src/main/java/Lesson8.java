import java.time.LocalTime;

public class Lesson8 {

    private static int[] arr1;
    private static int[] arr2;
    private static int[] arr3;
    private static int[] arr11;
    private static int[] arr12;
    private static int[] arr13;
    private static int[] arr21;
    private static int[] arr22;
    private static int[] arr23;
    private static int[] arr31;
    private static int[] arr32;
    private static int[] arr33;
    private static int countHaoraSravnenie = 0;
    private static int countHaoraZapis = 0;
    private static int countShellaSravnenie = 0;
    private static int countShellaZapis = 0;
    private static int countUlVstavka = 0;
    private static int count;

    public static void main(String[] args) {

        createTestArray();


        runHaora(arr11);

        runShella(arr12);

//        runHaora(arr11);
// переделать, не работает сейчас
//        runUlVstavka(arr2);

    }

    private static void runUlVstavka(int[] array) {

        Long startTime = LocalTime.now().toNanoOfDay();
        ulVstavka(array);
        Long endTime = LocalTime.now().toNanoOfDay();
        double runTimeSortHoara = (endTime - startTime) / 1000000000;
        System.out.print('\n' + "Время работы алгоритма Улучшенной Вставки обрабатывающего " + array.length + " элементов: " + runTimeSortHoara + " секунд" + '\n');
//        printArray(array);
        checkArray(array);

    }

    private static void runShella(int[] array) {

        Long startTime = LocalTime.now().toNanoOfDay();
        shella(array);
        Long endTime = LocalTime.now().toNanoOfDay();
        double runTimeSortHoara = (endTime - startTime) / 1000000000;
        System.out.print('\n' + "Время работы алгоритма Шелла обрабатывающего " + array.length + " элементов: " + runTimeSortHoara + " секунд" + '\n');
        System.out.print("Количесвто сравнений алгоритма Шелла " + countShellaSravnenie + " перезаписей: " + countShellaZapis + '\n');
//        printArray(array);
        checkArray(array);
        countShellaSravnenie = 0;
        countShellaZapis = 0;

    }

    private static void runHaora(int[] array) {

        Long startTime = LocalTime.now().toNanoOfDay();
        sortHoara(array, 0, array.length);
        Long endTime = LocalTime.now().toNanoOfDay();
        double runTimeSortHoara = (endTime - startTime) / 1000000000;
        System.out.print('\n' + "Время работы алгоритма Хоара обрабатывающего " + array.length + " элементов: " + runTimeSortHoara + " секунд" + '\n');
        System.out.print("Количество сравнений алгоритма Хоара " + countHaoraSravnenie + " перезаписей: " + countHaoraZapis + '\n');
        //        printArray(array);
        checkArray(array);
        countHaoraZapis = 0;
        countHaoraSravnenie = 0;
    }


    private static void shella(int[] array) {
        int d = array.length / 2;
        while (d > 0) {
            countShellaSravnenie++;
            for (int i = d; i < array.length; i++) {
                countShellaSravnenie++;
                int t = array[i];
                int j = i;
                while (j >= d && t < array[j - d]) {
                    countShellaSravnenie++;
                    int temp = array[j];
                    array[j] = array[j - d];
                    array[j - d] = temp;
                    countShellaZapis += 3;
                    j = j - d;
                }
            }
            d = d / 2;
        }


    }

    private static void ulVstavka(int[] array) {
        int left;
        int right;
        int middle;
        int x;
        for (int i = 1; i < array.length; i++) {

            if (array[i - 1] > array[i]) {

                x = array[i];
                left = 0;
                right = i - 1;


                middle = (left + right) / 2;

                if (array[middle] < x) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }

                if (left > right) {
                    for (int j = i - 1; j >= left; j--) {
                        array[j + 1] = array[j];
                        array[left] = x;
                    }
                }


            }
        }

    }

    private static void sortHoara(int[] array, int start, int end) {

//        int min = array[0];
//        int max = array[0];
//      ищем максимальное и минимальное значение в массиве
//        for (int i = start; i < end - 1; i++) {
//            if (max < array[i]) max = array[i];
//            else if (min > array[i]) min = array[i];
//            countHaoraSravnenie += 2;
//        }
////      выбираем опорный элемент, опорным делаем среднее арифметическое число
//        int middle = (max + min) / 2;

        int middle = (end - start) / 2;

//        for (int i = start; i < end; i++) {
//            countHaoraSravnenie++;
//            if (array[i] == middle) {
//                middle = i;
//                break;
//            }
//        }
//        if (middle == (min + max) / 2) middle = (start + end) / 2;

        int tempValue;
        int tempLeft = 0;
        int tempRight = 0;
        boolean flagRight = false;
        boolean flagLeft = false;

        for (int i = 0; i < end - middle; i++) {
            countHaoraSravnenie++;
            for (int j = 0; j < end - middle; j++) {
                countHaoraSravnenie++;
                if (array[i] > array[middle]) {
                    tempLeft = j;
                    flagLeft = true;
                    break;
                }
            }
            for (int j = end - 1; j > middle; j--) {
                countHaoraSravnenie++;
                if (array[j] < array[middle]) {
                    countHaoraSravnenie++;
                    tempRight = j;
                    flagRight = true;
                    break;
                }
            }
            if (flagLeft == true && flagRight == true) {
                tempValue = array[tempLeft];
                array[tempLeft] = array[tempRight];
                array[tempRight] = tempValue;
            }else if (flagLeft == true && flagRight == false){

                tempValue = array[tempLeft];
                for (int j = tempLeft; j <= middle; j++) {
                    array[j] = array[j+1];
                }
                array[middle] = tempValue;

            }else if (flagLeft == false && flagRight == true){
                tempValue = array[tempRight];
                for (int j = tempRight; j < end - 1 ; j++) {
                    array[j] = array[j-1];
                }
                array[middle] = tempValue;

            }
        }
        for (
                int j = end - 1;
                j > middle; j--)

        {
            countHaoraSravnenie++;
            if (array[j] <= array[middle]) {
                for (int i = 0; i < middle; i++) {

                }
                tempValue = array[j];
                array[j] = array[middle];
                array[middle] = tempValue;
                countHaoraZapis += 3;
            }
        }

        if (start - end > 1)

        {
            countHaoraSravnenie++;
            sortHoara(array, start, middle - 1);
            sortHoara(array, middle + 1, end);
        }


    }


    private static void checkArray(int[] array) {
        boolean flag = false;
        int countException = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                flag = true;
                countException++;
            }
        }
        if (flag == false) {
            System.out.println("goodSort");
        } else System.out.println("badSort: " + countException+ " несовпадений");
    }

    private static void printArray(int[] array) {
        for (int i :
                array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }

    private static void createTestArray() {

        arr1 = new int[100];
        arr2 = new int[100];
        arr3 = new int[100];

        arr11 = new int[10000];
        arr12 = new int[10000];
        arr13 = new int[10000];

        arr21 = new int[1000000];
        arr22 = new int[1000000];
        arr23 = new int[1000000];

        arr31 = new int[100000000];
        arr32 = new int[100000000];
        arr33 = new int[100000000];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (1 + Math.random() * 9999);
        }
        for (int i = 0; i < arr11.length; i++) {
            arr11[i] = (int) (1 + Math.random() * 9999);
        }
        for (int i = 0; i < arr21.length; i++) {
            arr21[i] = (int) (1 + Math.random() * 9999);
        }
        for (int i = 0; i < arr31.length; i++) {
            arr31[i] = (int) (1 + Math.random() * 9999);
        }

        arr2 = arr1.clone();
        arr3 = arr1.clone();

        arr12 = arr11.clone();
        arr13 = arr11.clone();

        arr22 = arr21.clone();
        arr23 = arr21.clone();

//        arr32 = arr31.clone();
        //      arr33 = arr31.clone();

        System.out.println("Mассивы созданы");
        System.out.println();

    }

}
