package lab3;

public class PouringWater {

    public static void main(String[] args) {

        pouring(0, 7, 4, 2, 7, 2);
    }

    private static void pouring(int container10, int container7, int container4, int target10, int target7, int target4) {
        // stopping rule
        if (container10 == target10 && container7 == target7 && container4 == target4) {
            System.out.print("(" + container10 + ", " + container7 + ", " + container4 + ")");
            return;
        }



    }


}
