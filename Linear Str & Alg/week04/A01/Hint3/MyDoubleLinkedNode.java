package Hint3;

/**
 * This class models the concept (a type of objects) of a single linked node<br>.
 */
public class MyDoubleLinkedNode<T> {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------
    private T info;
    private MyDoubleLinkedNode<T> left;
    private MyDoubleLinkedNode<T> right;

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------

    /**
     * The constructor creates 1 instance (1 object) of the class MyDoubleLinkedNode<br>
     *
     * @param l: The MyNode placed next to the left (referenced) from this object.
     * @param e: The element contained in MyDoubleLinkedNode.
     * @param r: The MyNode placed next to the right (referenced) from this object.
     */
    public MyDoubleLinkedNode(MyDoubleLinkedNode<T> l, T e, MyDoubleLinkedNode<T> r) {
        this.left = l;
        this.info = e;
        this.right = r;
    }

    //--------------------------------------------------
    // Get methods
    //--------------------------------------------------

    /**
     * Given a concrete MyNode (this), the function returns its content.<br>
     *
     * @return The content of the concrete object (this) calling to the method.
     */
    public T getInfo() {
        return this.info;
    }

    /**
     * Given a concrete MyNode (this), the function returns the MyNode placed next to the left (referenced) from this object.<br>
     *
     * @return The content of the concrete MyNode placed next to the left (referenced) from this object.
     */
    public MyDoubleLinkedNode<T> getLeft() {
        return this.left;
    }

    //--------------------------------------------------
    // Set methods
    //--------------------------------------------------

    /**
     * Given a concrete MyNode (this), the function modifies the MyNode placed next to the left (referenced) from this object.<br>
     *
     * @param n: The new MyNode placed next to the left (referenced) from this object.
     */
    public void setLeft(MyDoubleLinkedNode<T> n) {
        this.left = n;
    }

    /**
     * Given a concrete MyNode (this), the function returns the MyNode placed next to the right (referenced) from this object.<br>
     *
     * @return The content of the concrete MyNode placed next to the right (referenced) from this object.
     */
    public MyDoubleLinkedNode<T> getRight() {
        return this.right;
    }

    /**
     * Given a concrete MyNode (this), the function modifies the MyNode placed next to the right (referenced) from this object.<br>
     *
     * @param n: The new MyNode placed next to the right (referenced) from this object.
     */
    public void setRight(MyDoubleLinkedNode<T> n) {
        this.right = n;
    }

}
