package Hint1;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using.
 */
public class DivideAndConquerAlgorithms {

    //-------------------------------------------------------------------
    // 1. maxInt --> Computes the maximum item of MyList
    //-------------------------------------------------------------------

    /**
     * The function computes the maximum item of m (-1 if m is empty).
     *
     * @param m: The MyList we want to compute its maximum item.
     * @return The maximum item of MyList
     */
    public int maxInt(MyList<Integer> m) {
        int res = -1;

        //===Identify===

        int scenario;
        //Empty
        if (m.length() == 0) {
            scenario = 1;
        } else {
            scenario = 2;
        }

        //===Implement===
        switch (scenario) {
            case 1:
                break;
            case 2:
                int myItem = m.getElement(0);
                m.removeElement(0);
                int nextItem = maxInt(m);
                m.addElement(0, myItem);
                res = Math.max(myItem, nextItem);
        }
        return res;
    }

    //-------------------------------------------------------------------
    // 2. isReverse --> Computes if MyList is sorted in decreasing order
    //-------------------------------------------------------------------

    /**
     * The function computes whether m is sorted in decreasing order or not.
     *
     * @param m: The MyList we want to check.
     * @return Whether m is sorted in decreasing order or not.
     */
    public boolean isReverse(MyList<Integer> m) {
        // TO-DO
        boolean res = false;
        // ===Identify==
        int scenario;
        if (m.length() <= 1) {
            scenario = 1;
        } else {
            scenario = 2;
        }
        // ===Implement===
        switch (scenario) {
            case 1:
                return true;
            case 2:
                int myItem = m.getElement(0);
                m.removeElement(0);
                boolean soFar = isReverse(m);
                res = myItem < m.getElement(0) && soFar;
                m.addElement(0, myItem);
        }
        return res;
    }

    //-------------------------------------------------------------------
    // 3. getNumAppearances --> Computes the amount of times that integer appears in MyList
    //-------------------------------------------------------------------

    /**
     * The function computes the amount of times that the integer n appears in m.
     *
     * @param m: The MyList we want to use.
     * @param n: The number we want to compute its appearances for.
     * @return The amount of appearances of n into m
     */
    public int getNumAppearances(MyList<Integer> m, int n) {
        // TO-DO
        int res = 0;
        // ===Identification===
        int scenario;
        if (m.length() == 0) {
            scenario = 1;
        } else if (m.length() == 1) {
            scenario = 2;
        } else {
            scenario = 3;
        }

        // ===Implementation===
        switch (scenario) {
            case 1:
                break;
            case 2:
                if (m.getElement(0) == n) {
                    res++;
                }
                break;
            case 3:
                int myItem = m.getElement(0);
                m.removeElement(0);
                res = res + getNumAppearances(m, n);
                if (myItem == n) {
                    res++;
                }
                m.addElement(0, myItem);
                break;
        }

        return res;
    }

    //-------------------------------------------------------------------
    // 4. power --> Computes the m-est power of n
    //-------------------------------------------------------------------

    /**
     * The function computes n to the power of m.
     *
     * @param n: The base number.
     * @param m: The power of n we want to compute
     * @return n to the power of m.
     */

    public int power(int n, int m) {
        int res = 1;
        int scenario;

        if (m == 0) {
            scenario = 1;
        } else {
            scenario = 2;
        }

        switch (scenario) {
            case 1:
                break;
            case 2:
                res = n * power(n, m - 1);
        }
        return res;
    }

    //-------------------------------------------------------------------
    // 5. lucas --> Computes the n-est term of the Lucas series
    //-------------------------------------------------------------------

    /**
     * The function computes the n-est term of the Lucas series
     *
     * @param n: The n-est term of the series we want to compute
     * @return The term being computed
     */
    public int lucas(int n) {
        // TO-DO
        int res = 2;
        int scenario;
        if (n == 0) {
            scenario = 1;
        } else if (n == 1) {
            scenario = 2;
        } else {
            scenario = 3;
        }

        switch (scenario) {
            case 1:
                res = 2;
                break;
            case 2:
                res = 1;
                break;
            case 3:
                res = lucas(n - 1) + lucas(n - 2);
                break;
        }
        return res;
    }

    //-------------------------------------------------------------------
    // 6. drawImage --> Prints a pattern of a given length
    //-------------------------------------------------------------------

    /**
     * The function prints prints a pattern of a given length.
     * *
     * **
     * ***
     * ...
     *
     * @param n: The length of the desired pattern
     */
    public void drawImage(int n) {

        int scenario;
        if (n == 0) {
            scenario = 1;
        } else {
            scenario = 2;
        }

        switch (scenario) {
            case 1:
                System.out.println();
                break;
            case 2:
                String stars = new String(new char[n]).replace("\0", "*");
                drawImage(n - 1);
                System.out.println(stars);
                break;
        }
    }
}