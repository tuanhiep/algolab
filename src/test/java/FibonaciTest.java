import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FibonaciTest {


    @Test
    public void fibo1Test() {
        int[] answer = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        for (int i = 0; i <= 10; i++) {
            assertTrue("Error, FIB1 Failed at " + i, answer[i] == Fibonaci.fibo1(i));
        }

    }

    @Test
    public void fibo2Test() {
        int[] answer = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        for (int i = 0; i <= 10; i++) {
            assertTrue("Error, FIB2 Failed at : " + i, answer[i] == Fibonaci.fibo2(i));
        }
    }
}