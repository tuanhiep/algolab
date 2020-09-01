public class Fibonaci {


    public static void main(String[] args) {
        int n = 15;
        // Test for the algorithm fibo1
        System.out.println("I. Test fibo1 for exponential algorithm ");
        String recoredTime1 = "";
        String number = "";
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            fibo1(i);
            long endTime = System.nanoTime();
            number += i + ",";
            recoredTime1 += (endTime - startTime) + ",";
        }
        System.out.println("For number is: " + number);
        System.out.println("Recorded time is: " + recoredTime1);
        // Test for the algorithm fibo2
        System.out.println("II. Test fibo1 for exponential algorithm ");
        String recoredTime2 = "";
        for (int i = 0; i <= n; i++) {
            long startTime = System.nanoTime();
            fibo2(i);
            long endTime = System.nanoTime();
            recoredTime2 += (endTime - startTime) + ",";
        }
        System.out.println("For number is: " + number);
        System.out.println("Recorded time is: " + recoredTime2);


    }

    /**
     * Calculate the Fibonaci number by exponential algorithm
     *
     * @param n
     * @return Fibonaci number
     */
    protected static int fibo1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibo1(n - 1) + fibo1(n - 2);

    }

    /**
     * Calculate the Fibonaci number by polynomial algorithm
     *
     * @param n
     * @return Fibonaci number
     */
    protected static int fibo2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

}
