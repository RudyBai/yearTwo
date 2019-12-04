
/**
 * The class contains the Divide and Conquer-based Algorithms we are using.
 */
public class DivideAndConquerAlgorithms {
    //----------------------------------------------
    // Class constructor
    //----------------------------------------------

    /**
     * Constructor of the class. Do not edit it.
     */
    public DivideAndConquerAlgorithms() {
    }

    //-------------------------------------------------------------------
    // 0. iterativeDisplayElements --> Displays all elements of a MyList
    //-------------------------------------------------------------------

    /**
     * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
     *
     * @param m: The MyList we want to display its elements.
     */
    public void iterativeDisplayElements(MyList<Integer> m) {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario = 0;

        //Rule 1. MyList is empty
        if (m.length() == 0)
            scenario = 1;
            //Rule 2. MyList is non-empty
        else
            scenario = 2;

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {

            //Rule 1. MyList is empty
            case 1:
                //1. We print the empty message
                System.out.println("Empty MyList");

                break;

            //Rule 2. MyList is non-empty
            case 2:
                //1. We print the initial message
                int size = m.length();
                System.out.println("MyList Contains the following " + size + " items: ");

                //2. We traverse the items
                for (int i = 0; i < size; i++)
                    System.out.println("Item " + i + ": " + m.getElement(i));

                break;

        }

    }

    //-------------------------------------------------------------------
    // 1. maxInt --> Computes the maximum item of MyList
    //-------------------------------------------------------------------

    /**
     * The function computes the maximum item of m (-1 if m is empty).
     *
     * @param m: The MyList we want to compute its maximum item.
     * @return: The maximum item of MyList
     */
    public int maxInt(MyList<Integer> m) {
        // TO-DO
        int res = -1;

        //===Identify===

        int scenario = 0;
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
                if (myItem >= nextItem) {
                    res = myItem;
                } else {
                    res = nextItem;
                }
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
     * @return: Whether m is sorted in decreasing order or not.
     */
    public boolean isReverse(MyList<Integer> m) {
        // TO-DO
        boolean res = false;
        // ===Identify==
        int scenario = 0;
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
                if (myItem < m.getElement(0) && soFar == true) {
                    res = true;
                } else {
                    res = false;
                }
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
     * @return: The amount of appearances of n into m
     */
    public int getNumAppearances(MyList<Integer> m, int n) {
        // TO-DO
        int res = 0;
        // ===Identification===
        int scenario = 0;
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
     * @return: n to the power of m.
     */

    public int power(int n, int m) {
        int res = 1;
        int scenario = 0;

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
     * @return: The term being computed
     */
    public int lucas(int n) {
        // TO-DO
        int res = 2;
        int scenario = 0;
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
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//            }
        int scenario = 0;
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
                drawImage( n - 1 );
                System.out.println(stars);
                break;
        }
    }
}