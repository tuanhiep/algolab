public class Fibonaci {


    public static void main(String[] args) {

        System.out.println(fibo1(2));
        System.out.println(fibo2(3));
    }

    /**
     * Calculate the Fibonaci number by exponential algorithm
     *
     * @param n
     * @return Fibonaci number
     */
    private static int fibo1(int n) {
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
    private static int fibo2(int n) {
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
