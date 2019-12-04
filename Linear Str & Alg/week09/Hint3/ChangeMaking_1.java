
/**
 * Classical Change making problem with an unlimited amount of coins of each type. <br>
 * Version 1: Selection function with basic policy: First available coin.<br>
 * Leads to non-optimal solution.<br>
 * The class encŁapsulates all the functions of the Greedy schema<br>
 */

public class ChangeMaking_1 {

    //---------------------------------------
    //	Constructor
    //---------------------------------------

    /**
     * Constructor of the class. Do not edit it.
     */
    public ChangeMaking_1() {
    }

    //-------------------------------------------------------------------
    // 0. printSolution --> Displays all elements of a MyList
    //-------------------------------------------------------------------

    /**
     * Given concrete MyLists of coinValues and solution, this function displays its elements by screen (if any).
     *
     * @param coinValues: The MyList with the available coins.
     * @param solution:   The MyList with the quantity of each coin in solution.
     */
    public void printSolution(MyList<Integer> coinValues, MyList<Integer> solution) {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;

        //Rule 1. MyList is empty
        if (coinValues.length() == 0)
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
                System.out.println("No coins have been provided.");

                break;

            //Rule 2. MyList is non-empty
            case 2:
                System.out.println("The algorithm came up with the following solution : ");
                for (int i = 0; i < coinValues.length(); i++) {
                    System.out.println("\t" + coinValues.getElement(i) + "c\t*  " + solution.getElement(i));
                }

        }

    }

    //-------------------------------------------------------------------
    // 1. getCandidate --> It selects the next candidate to be considered.
    //-------------------------------------------------------------------

    /**
     * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br>
     * The policy followed is very simple: Just pick the first non-discarded type of coin.
     *
     * @param discarded:  The MyList stating whether a candidate has been discarded so far or not.
     * @param coinValues: A MyList containing the value of each type of coin supported.
     * @return: The index of candidate to be selected.
     */
    public int getCandidate(MyList<Integer> discarded, MyList<Integer> coinValues) {

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        int res = -1;

        //-----------------------------
        //SET OF OPS

        //-----------------------------

        // Scan coinValues
        // Assign in false to inDiscarded
        // Scan discarded
        // if in set to true
        // if False return i

        for (int i = 0; i < coinValues.length(); i++) {
            if (!discarded.getElement(i).equals(coinValues.getElement(i))) {
                return i;
            }
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // 2. isValid --> It selects if a candidate can be added to the solution.
    //-------------------------------------------------------------------

    /**
     * Given a current solution and a selected candidate, this function
     * states whether the candidate must be added to the solution or discarded.<br>
     *
     * @param coinValues:      A MyList containing the value of each type of coin supported.
     * @param amount:          The amount of change we want to generate.
     * @param changeGenerated: The quantity of change we have generated so far.
     * @param itemSelected:    The index of the candidate selected.
     * @return: Whether the candidate fits or not into the solution.
     */

    public boolean isValid(MyList<Integer> coinValues, int amount, int changeGenerated, int itemSelected) {

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        boolean res = false;

        //-----------------------------
        //SET OF OPS
        //-----------------------------

        if (changeGenerated + coinValues.getElement(itemSelected) <= amount) {
            res = true;
        }

        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // 3. isFinal --> It selects if the current solution is the final solution
    //-------------------------------------------------------------------

    /**
     * Given a current solution, this function states whether it is a final solution or it can still be improved.<br>
     * To determine it, it checks whether there is (at least) one more coin that can be used as part of the change.
     * <p>
     * !!! THIS SOLUTION IS ONLY EFFICIENT FOR COINS !!! There will only be a maximum of 8 potential Coin Values.
     * <p>
     * For application where there are more potential candidates this function should check
     * if (changeGenerated != amount);
     * for (...) {
     * ...
     * }
     *
     * @param discarded: The MyList stating whether a candidate has been discarded so far or not.
     * @return: Whether the current solution is the final solution.
     */
    public boolean isFinal(MyList<Integer> discarded) {

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        boolean res = true;

        //-----------------------------
        //SET OF OPS
        //-----------------------------
        for (int i = 0; i < discarded.length(); i++) {
            if (discarded.getElement(i) == 0) {
                res = false;
                break;
            }
        }

        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // 4. objectiveFunction --> This function computes the value of the final solution.
    //-------------------------------------------------------------------

    /**
     * Given the final solution to the problem, this function
     * computes its value according to:<br>
     * How many coins are used in the solution.<br>
     * How accurate it is the change.<br>
     *
     * @param sol:             The MyList containing the solution to the problem.
     * @param changeGenerated: The change generated by the current solution.
     * @param amount:          The amount of change we want to generate.
     * @return: The value of such solution.
     */
    public MyList<Float> getQuality(MyList<Integer> sol, float changeGenerated, float amount) {

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        MyList<Float> res = new MyDynamicList<>();
        //-----------------------------
        //SET OF OPS
        //-----------------------------
        int coins = 0;
        for (int i = 0; i < sol.length(); i++) {
            coins += sol.getElement(i);
        }
        float accuracy;
        accuracy = amount / changeGenerated;

        res.addElement(0, accuracy);
        res.addElement(0, (float) coins);
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // 5. solve --> This function solves the problem using a greedy algorithm.
    //-------------------------------------------------------------------

    /**
     * Given an instance of the GP1 problem, this function solves it using
     * a greedy algorithm.<br>
     *
     * @param coinValues: A MyList containing the value of each type of coin supported.
     * @param amount:     The amount of change we want to generate.
     * @return: A MyList containing the amount of coins of each type being selected.
     */
    public MyList<Integer> solve(MyList<Integer> coinValues, int amount) {
        //-----------------------------
        //Intro
        //-----------------------------
        if (coinValues.length() > 0) {
            System.out.print("Coins Provided         : [");
            for (int i = 0; i < coinValues.length(); i++) {
                if (i == coinValues.length() - 1) {
                    System.out.println(coinValues.getElement(i) + "]");
                } else {
                    System.out.print(coinValues.getElement(i) + ", ");
                }
            }
            System.out.println("Amount to be generated : " + amount);
            System.out.println();

        }

        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------

        MyList<Integer> res = new MyDynamicList<>();
        MyList<Integer> discarded = new MyDynamicList<>();
        int currentIndex;
        int changeGenerated = 0;

        //-----------------------------
        //SET OF OPS
        //-----------------------------
        // This if should be replaced by encapsulating whole function in switch case
        if (coinValues.length() > 0) {

            // Set res and discarded to zeros
            for (int i = 0; i < coinValues.length(); i++) {
                discarded.addElement(0, 0);
                res.addElement(0, 0);
            }

            while (!isFinal(discarded)) {

                currentIndex = getCandidate(discarded, coinValues);

                while (isValid(coinValues, amount, changeGenerated, currentIndex)) {
                    changeGenerated += coinValues.getElement(currentIndex);
                    //======================================================================
                    int x = res.getElement(currentIndex);
                    res.removeElement(currentIndex);
                    res.addElement(currentIndex, (x + 1));
                }
                discarded.removeElement(currentIndex);
                discarded.addElement(currentIndex, coinValues.getElement(currentIndex));
            }
        }

        this.printSolution(coinValues, res);
        if (coinValues.length() > 0) {
            MyList quality = getQuality(res, changeGenerated, amount);
            System.out.println("Accuracy : " + quality.getElement(1));
            System.out.println("Coins : " + quality.getElement(0));
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

}