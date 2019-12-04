
/**
* The main class of our project.<br>. 
*/
public class MyMain {

	//-------------------------------------
	//	testMyQueue 
	//-------------------------------------	
	/** 
	* This function test the MyList interface and its static implementation.<br>
	*/
	public static void testMyList() {
		
		//-------------------------------------
		//	1. We create MyList
		//-------------------------------------
		MyList m;
		//m = my_create_empty(); //--> We cannot create a new MyList using explicitly myCreateEmpty()
		m = new MyStaticList(3); //--> Instead we choose to follow the implementation class. 

		//-------------------------------------
		//	2. isEmpty 
		//-------------------------------------
		System.out.println("Num of elements: " + m.length()); //--> The current length is 0 as MyList is created initially empty
				
		//-------------------------------------
		//	3. Add three elements 
		//-------------------------------------
		m.addElement(0,3); //--> m : [3]
		m.addElement(1,4);	//--> m : [3, 4]	
		m.addElement(3,6); //--> Fails, as MyList does not have that many elements	
		m.addElement(2,5); //--> m : [3, 4, 5]
		m.addElement(0,6); //--> Fails, as MyList is already full
		
		//-------------------------------------
		//	4. Get the first item in MyList 
		//-------------------------------------	
		System.out.println("First item = " + m.getElement(0)); //--> Returns 3
		System.out.println("Second item = " + m.getElement(1)); //--> Returns 4		
		m.removeElement(0); //--> m : [4, 5]
		m.getElement(2); //--> Fails, MyList does not have that many elements	
		System.out.println("First item = " + m.getElement(0)); //--> Returns 4
		
		//-------------------------------------
		//	5. Remove two elements and fail to remove another one
		//-------------------------------------			
		m.removeElement(1); //--> m : [4]
		m.removeElement(0); //--> m : []
		m.removeElement(0); //--> Fails, MyList is already empty
	}
	
	//-------------------------------------
	//	main 
	//-------------------------------------		
	/**
	 * Main Method:<br> 
	 * Calls to the function testMyQueue to test MyQueue and its implementation.<br>
	 * @param args: We will run the program parameter free, so do not worry about it. 
	 */	
	public static void main(String[] args) {
		//1. We call to the function testMyQueue
		testMyList();
	}

}
