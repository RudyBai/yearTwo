package Hint3;

/**
 * ADT MyStack: Private Part<br>.
 * The class implements all the operations available in MyStack<br>
 */
public class MyDoubleDynamicStack<T> implements MyStackHint3<T> {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------
    private MyDoubleLinkedNode<T> head;
    private MyDoubleLinkedNode<T> tail;
    private int numItems;
    //-------------------------------------------------------------------
    // Basic Operation --> Check if myStack is empty: myCreateEmpty
    //-------------------------------------------------------------------
    //public myStack myCreateEmpty(){}

    public MyDoubleDynamicStack() {
        this.head = null;
        this.tail = null;
        this.numItems = 0;
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Check if myStack is empty: isEmpty
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
        //empty
        if (numItems == 0) {
            scenario = 1;
        }
        //not empty
        else {
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
    // Basic Operation (Partial) --> Get first element from front of MyStack: first
    //-------------------------------------------------------------------

    public T first() {
        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        T res = null;

        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //empty
        if (this.numItems == 0) {
            scenario = 1;
        }
        //not empty
        else {
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
                res = this.head.getInfo();
                break;
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Add element to back of MyStack: addByFirst
    //-------------------------------------------------------------------

    public void addByFirst(T element) {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //empty
        if (this.numItems == 0) {
            scenario = 1;
        }
        //not empty
        else {
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        //initialise object
        MyDoubleLinkedNode<T> node = new MyDoubleLinkedNode<>(null, element, null);
        //switch
        switch (scenario) {
            case 1:
                this.head = node;
                this.tail = node;
                this.numItems++;
                break;
            case 2:
                this.head.setLeft(node);
                node.setRight(this.head);
                this.head = node;
                this.numItems++;
                break;
        }
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Remove element from front of MyStack: removeByFirst
    //-------------------------------------------------------------------

    public void removeByFirst() {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //empty
        if (this.numItems == 0) {
            scenario = 1;
        }
        //more than one item
        else if (this.numItems > 1) {
            scenario = 2;
        }
        //one item left
        else {
            scenario = 3;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("The stack is empty");
                break;
            case 2:
                this.head = this.head.getRight();
                this.head.setLeft(null);
                this.numItems--;
                break;
            case 3:
                //this.head = this.head.getRight();
                this.head = null;
                this.tail = null;
                this.numItems--;
                break;
        }
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Get first element from front of MyStack: last
    //-------------------------------------------------------------------

    public T last() {
        //-----------------------------
        //Output Variable --> InitialValue
        //-----------------------------
        T res = null;

        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //empty
        if (isEmpty()) {
            scenario = 1;
        }
        //not empty
        else {
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("Stack is empty.");
                break;
            case 2:
                res = this.tail.getInfo();
                break;
        }
        //-----------------------------
        //Output Variable --> Return FinalValue
        //-----------------------------
        return res;
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Add element to back of MyStack: addByLast
    //-------------------------------------------------------------------

    public void addByLast(T element) {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //empty
        if (isEmpty()) {
            scenario = 1;
        }
        //not empty
        else {
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        //initialise object
        MyDoubleLinkedNode<T> node = new MyDoubleLinkedNode<>(null, element, null);
        //switch
        switch (scenario) {
            case 1:
                this.head = node;
                this.tail = node;
                this.numItems++;
                break;
            case 2:
                this.tail.setRight(node);
                node.setLeft(this.tail);
                this.tail = node;
                this.numItems++;
                break;
        }
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Remove element from front of MyStack: removeByFirst
    //-------------------------------------------------------------------

    public void removeByLast() {
        //-----------------------------
        //SET OF OPS
        //-----------------------------

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //empty
        if (isEmpty()) {
            scenario = 1;
        }
        //more than one item
        else if (this.numItems > 1) {
            scenario = 2;
        }
        //one item left
        else {
            scenario = 3;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("The stack is empty");
                break;
            case 2:
                this.tail = this.tail.getLeft();
                this.tail.setRight(null);
                this.numItems--;
                break;
            case 3:
                this.tail = this.tail.getLeft();
                this.tail = null;
                this.head = null;
                this.numItems--;
                break;
        }
    }
}