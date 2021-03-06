package Hint1;

import java.util.Arrays;

/**
 * ADT MyStack: Private Part<br>.
 * The class implements all the operations available in MyStack<br>
 */
public class MyStaticStack implements MyStack {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------
    private int[] items;
    private int numItems;
    private int maxItems;
    //-------------------------------------------------------------------
    // Basic Operation --> Check if myStack is empty: myCreateEmpty
    //-------------------------------------------------------------------
    //public myStack myCreateEmpty(){}

    public MyStaticStack(int maxItems) {
        this.maxItems = maxItems;
        this.items = new int[this.maxItems];
        this.numItems = 0;
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Check if MyStack is empty: isEmpty
    //-------------------------------------------------------------------

    public boolean isEmpty() {
        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        boolean res = true;

        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario = 0;
        //numItems == 0
        if (this.numItems == 0) {
            scenario = 1;
        }
        //numItems > 0
        else if (this.numItems > 0) {
            scenario = 2;
        }

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                break;
            case 2:
                res = false;
                break;
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Get and remove first element from top of MyStack: pop
    //-------------------------------------------------------------------

    public int pop() {
        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        int res = -1;

        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //no items in stack
        if (this.numItems == 0) {
            scenario = 1;
        }
        //items in stack
        else {
            scenario = 2;
        }

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("No items in stack.");
                break;
            case 2:
                //Return value
                res = this.items[0];
                //Move all items one left
                if (this.numItems - 1 >= 0) System.arraycopy(this.items, 1, this.items, 0, this.numItems - 1);
                this.items[this.numItems - 1] = 0;
                this.numItems -= 1;
                break;
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }


    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Add element to the top of MyStack: push
    //-------------------------------------------------------------------

    public void push(int element) {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //stack is empty
        if (this.numItems == 0) {
            scenario = 1;
        }
        //stack is has elements but is not full
        else if (this.numItems > 0 && this.numItems < this.maxItems) {
            scenario = 2;
        }
        //stack is full
        else {
            scenario = 3;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                this.items[0] = element;
                this.numItems = this.numItems + 1;
                System.out.println("Element " + element + " successfully added.");
                break;
            case 2:
                System.arraycopy(this.items, 0, this.items, 1, this.numItems);
                this.items[0] = element;
                this.numItems = this.numItems + 1;
                System.out.println("Element " + element + " successfully added.");
                break;
            case 3:
                System.out.println("The stack is full.");
                break;
        }
    }
    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> prints all the elements from MyStack: print
    //-------------------------------------------------------------------

    public void print() {

        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //isEmpty()
        if (isEmpty()) {
            scenario = 1;
        } else {
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("The stack is empty.");
                break;
            case 2:
                System.out.println(Arrays.toString(this.items));
                break;
        }
    }
}