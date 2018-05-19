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
//        printArray(array);
        checkArray(array);

    }

    private static void runHaora(int[] array) {

        Long startTime = LocalTime.now().toNanoOfDay();
        sortHoara(array, 0, array.length);
        Long endTime = LocalTime.now().toNanoOfDay();
        double runTimeSortHoara = (endTime - startTime) / 1000000000;
        System.out.print('\n' + "Время работы алгоритма Хоара обрабатывающего " + array.length + " элементов: " + runTimeSortHoara + " секунд" + '\n');
//        printArray(array);
        checkArray(array);
    }


    private static void shella(int[] array) {
        int d = array.length / 2;
        while (d > 0) {
            for (int i = d; i < array.length; i++) {
                int t = array[i];
                int j = i;
                while (j >= d && t < array[j - d]) {
                    int temp = array[j];
                    array[j] = array[j - d];
                    array[j - d] = temp;
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

        int min = array[0];
        int max = array[0];
//      ищем максимальное и минимальное значение в массиве
        for (int i = start; i < end-1; i++) {
            if (max < array[i]) max = array[i];
            else if (min > array[i]) min = array[i];
        }
//      выбираем опорный элемент, опорным делаем среднее арифметическое число
        int middle = (max + min) / 2;

        for (int i = start; i < end; i++) {
            if (array[i] == middle) middle = i;
            break;
        }
        if (middle == (min+max)/2)middle=(start+end)/2;

//        int middle = (start + end) / 2;
        int tempValue;

        for (int i = 0; i < array.length - middle; i++) {
            if (array[i] > array[middle]) {
                for (int j = array.length - 1; j > middle; j--) {
                    if (array[j] <= array[middle]) {
                        tempValue = array[i];
                        array[i] = array[j];
                        array[j] = tempValue;
                        break;
                    }
                }
            }
        }
        for (int j = array.length - 1; j > middle; j--) {
            if (array[j] <= array[middle]) {
                tempValue = array[j];
                array[j] = array[middle];
                array[middle] = tempValue;
            }
        }

        if (start - end != 1) {
            sortHoara(array, start, middle - 1);
            sortHoara(array, middle + 1, end);
        }


    }


    private static void checkArray(int[] array) {
        boolean flag = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                flag = true;
                break;
            }
        }
        if (flag == false) {
            System.out.println("ok");
        } else System.out.println("badSort");
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

        arr32 = arr31.clone();
        arr33 = arr31.clone();

        System.out.println("Mассивы созданы");
        System.out.println();

    }

}
