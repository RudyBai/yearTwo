package Hint2;

/**
* This class models the concept (a type of objects) of a single linked node<br>. 
*/
public class MyNode {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private int info;
	private MyNode next;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	/**
	 * The constructor creates 1 instance (1 object) of the class MyNode<br>
	 * @param info: The element contained in MyNode.
	 * @param nextNode: The MyNode placed next (referenced) from this object.
	 */
	public MyNode(int info, MyNode nextNode){
		this.info = info;
		this.next = nextNode;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	/**
	 * Given a concrete MyNode (this), the function returns its content.<br>
	 * @return The content of the concrete object (this) calling to the method.
	 */	
	public int getInfo(){
		return this.info;
	}
	
	/**
	 * Given a concrete MyNode (this), the function returns the MyNode placed next (referenced) from this object.<br>
	 * @return The content of the concrete MyNode placed next (referenced) from this object.
	 */	
	public MyNode getNext(){
		return this.next;
	}
}