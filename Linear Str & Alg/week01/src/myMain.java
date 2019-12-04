/**
 * The class tests the 8 exercises of the exam.
 * @author Ignacio.Castineiras
 *
 */
public class myMain {

    /**
     * Main Method: Used to test the exam exercises.
     * @param args: We will run the program parameter free, so do not worry about it.
     */
    public static void main(String[] args) {
        //1. We create the object to test the exercises
        exercises ex = new exercises();

        //2. We create extra variables for the results
        int res1;
        String res2;

        //---------------------
        // TESTS
        //---------------------

        //ex1
        System.out.println("----------- ex1 -----------");
        ex.ex1();

        //ex2
        System.out.println("---------- ex2 -----------");
        res1 = ex.ex2(2, 3);
        System.out.println(res1);

        res1 = ex.ex2(5, 7);
        System.out.println(res1);

        //ex3
        System.out.println("----------- ex3 -----------");
        ex.ex3(3, 7, 5);
        ex.ex3(1, 2, 3);

        //ex4
        System.out.println("----------- ex4 -----------");
        res1 = ex.ex4(5);
        System.out.println(res1);

        res1 = ex.ex4(10);
        System.out.println(res1);

        //ex5
        System.out.println("----------- ex5 -----------");
        ex.ex5(3);

        ex.ex5(5);

        //ex6
        System.out.println("----------- ex6 -----------");
        res2 = ex.ex6("Hello");
        System.out.println(res2);

        res2 = ex.ex6("Goodbye");
        System.out.println(res2);

        //ex7
        System.out.println("----------- ex7 -----------");
        res1 = ex.ex7(16);
        System.out.println(res1);

        res1 = ex.ex7(942);
        System.out.println(res1);
    }

}
