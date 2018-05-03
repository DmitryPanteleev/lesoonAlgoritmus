import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Lesson3 {

    private static long countSortSheikUl = 0;
    private static long countSortUl = 0;
    private static long countSort = 0;
    private static double timeSortUl;
    private static double timeSort;
    private static double timeSortSheikUl;

    public static void main(String[] args) {
//        int size = 10000;

        double j = 1;
        List<int[]> dadArray = new ArrayList<int[]>();
        while (j < 4) {

            int[] arr = new int[(int) (Math.pow(100, j))];

            int i = 0;
            while (i < arr.length) {
                arr[i] = (int) (1 + Math.random() * 99);
//            System.out.print(arr[i] + " ");
                i++;
            }

            int[] arr2 = (int[]) arr.clone();
            int[] arr3 = (int[]) arr.clone();

            dadArray.add(arr);
            dadArray.add(arr2);
            dadArray.add(arr3);
            j++;
        }
        System.out.println("create arr");


        System.out.println();
        System.out.println("start sort " + dadArray.get(0).length + ": " + LocalTime.now());
        sort(dadArray.get(2));
        sortUl(dadArray.get(1));
        sortSheikUl(dadArray.get(0));
        System.out.println("Сортировка пузырьком:            " + countSort + " циклов перезаписи и " + timeSort + " секунд выполнение");
        System.out.println("Сортировка пузырьком улучшенная: " + countSortUl + " циклов перезаписи и " + timeSortUl + " секунд выполнение");
        System.out.println("Сортировка шейкером:             " + countSortSheikUl + " циклов перезаписи и " + timeSortSheikUl + " секунд выполнение");
        System.out.println("start sort " + dadArray.get(3).length + ": " + LocalTime.now());
        sort(dadArray.get(5));
        sortUl(dadArray.get(4));
        sortSheikUl(dadArray.get(3));
        System.out.println("Сортировка пузырьком:            " + countSort + " циклов перезаписи и " + timeSort + " секунд выполнение");
        System.out.println("Сортировка пузырьком улучшенная: " + countSortUl + " циклов перезаписи и " + timeSortUl + " секунд выполнение");
        System.out.println("Сортировка шейкером:             " + countSortSheikUl + " циклов перезаписи и " + timeSortSheikUl + " секунд выполнение");
        System.out.println("start sort " + dadArray.get(6).length + ": " + LocalTime.now());
        sort(dadArray.get(8));
        sortUl(dadArray.get(7));
        sortSheikUl(dadArray.get(6));
        System.out.println("Сортировка пузырьком:            " + countSort + " циклов перезаписи и " + timeSort + " секунд выполнение");
        System.out.println("Сортировка пузырьком улучшенная: " + countSortUl + " циклов перезаписи и " + timeSortUl + " секунд выполнение");
        System.out.println("Сортировка шейкером:             " + countSortSheikUl + " циклов перезаписи и " + timeSortSheikUl + " секунд выполнение");


    }

    private static void sort(int[] array) {
        double startSort = System.currentTimeMillis();
        int i = 0;
        int max;
        int j = 0;

        while (j < array.length - 1) {
            while (i + 1 < array.length) {


                if (i + 1 < array.length) {

                    if (array[i] > array[i + 1]) {
                        max = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = max;
                        countSort++;
                    }
                    i++;
                }
            }
            j++;
            i = 0;
        }
        double endSort = System.currentTimeMillis();
        timeSort = (endSort - startSort) / 1000;
    }

    private static void sortUl(int[] array) {
        double startSortUl = System.currentTimeMillis();
        int i = 0;
        int j = 0;
        int max;
        int fix = 0;

        while (j < array.length - fix) {
            while (i + 1 < array.length - fix) {


                if (i + 1 < array.length) {

                    if (array[i] > array[i + 1]) {
                        max = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = max;
                        countSortUl++;
                    }
                    i++;
                }

            }
            fix++;
            i = 0;

            j++;
        }
        double endSortUl = System.currentTimeMillis();
        timeSortUl = (endSortUl - startSortUl) / 1000;
    }

    private static void printArray(int[] arr) {

        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();
        System.out.println("Count: " + countSortSheikUl);
    }

    private static void sortSheikUl(int[] array) {
        double startSortSheikUl = System.currentTimeMillis();
        int i = 0;
        int j = 0;
        int max;
        int min;
        int fix = 0;
        int fix2 = 0;

        while (j < array.length - 1) {
            if (j % 2 == 0) {
                while (i + 1 + fix2 < array.length - fix) {


                    if (i + 1 < array.length) {

                        if (array[i + fix2] > array[i + 1]) {
                            max = array[i];
                            array[i] = array[i + 1];
                            array[i + 1] = max;
                            countSortSheikUl++;
                        }
                        i++;
                    }

                }
                fix++;
            } else {
                while (i > 0 + fix2) {

                    if (i - fix - 1 >= 0) {

                        if (array[i - fix] < array[i - fix - 1]) {
                            min = array[i - fix];
                            array[i - fix] = array[i - fix - 1];
                            array[i - fix - 1] = min;
                            countSortSheikUl++;
                        }
                    }
                    i--;

                }
                fix2++;
            }

            if (fix2 == array.length / 2) {
                j = array.length;
            } else {
                j++;
            }
        }
        double endSortSheikUl = System.currentTimeMillis();
        timeSortSheikUl = (endSortSheikUl - startSortSheikUl) / 1000;
    }

    private static int binarySearch(int[] arr, int search) {

        int centr = arr.length / 2;
        while (true) {
            if (search == arr[centr]) return centr;
            else if (search > arr[centr]) centr = (arr.length - centr) / 2;
            else centr = centr / 2;
        }
    }
}
