public class Lesson7 {

    public static void main(String[] args) {
//  6. Переписать программу алгоритма Дейкстры на свой язык программирования

        dekstra();

    }

    private static void dekstra() {
        final int N = 6;
        int[][] W = {{1000,2,5,0,7},
                {2,1000,1,0,0},
                {5,1,1000,5,1},
                {0,0,5,1000,3},
                {7,0,1,3,1000}};
        int[] active = {0, 0, 0, 0, 0, 0};
        int[] Route = new int[N];
        int[] Peak = new int[N];
        int min, kMin;

        for (int i = 0; i < N; i++) {
            active[i] = 1;
            Route[i] = W[0][i];
            Peak[i] = -1;
        }
        active[0] = 0;
        for (int i = 0; i < N; i++) {

        }



    }

}
