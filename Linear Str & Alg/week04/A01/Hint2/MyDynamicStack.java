package Hint2;

import Hint1.MyStack;

/**
 * ADT MyStack: Private Part<br>.
 * The class implements all the operations available in MyStack<br>
 */
public class MyDynamicStack implements MyStack {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------
    private MyNode initial;
    private int numItems;
    //-------------------------------------------------------------------
    // Basic Operation --> Check if MyStack is empty: myCreateEmpty
    //-------------------------------------------------------------------
    //public myStack myCreateEmpty(){}

    public MyDynamicStack() {
        this.initial = null;
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
        int scenario;
        //initial = null == is empty
        if (this.initial == null) {
            scenario = 1;
        } else {
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
    // Basic Operation (Partial) --> Get first element from the top of MyStack and removes it: pop
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
        //list is empty
        if (this.initial == null) {
            scenario = 1;
        }
        //list is not empty
        else {
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("The stack is empty.");
                //res = 0;
                break;
            case 2:
                res = this.initial.getInfo();
                this.initial = this.initial.getNext();
                this.numItems--;
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
        //list is empty
        if (this.numItems == 0) {
            scenario = 1;
        }
        //else
        else {
            scenario = 2;
        }


        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                this.initial = new MyNode(element, null);
                this.numItems++;
                break;
            case 2:
                this.initial = new MyNode(element, this.initial);
                this.numItems++;
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
        //stack is empty
        if (this.numItems == 0) {
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
                MyNode i = this.initial;
                System.out.print("[");
                while (i != null) {
                    if (i.getNext() != null) {
                        System.out.print(i.getInfo() + ", ");
                        i = i.getNext();
                    } else {
                        System.out.print(i.getInfo() + "]");
                        break;
                    }
                }
        }
    }
}