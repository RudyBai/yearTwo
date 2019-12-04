
/**
* The main class of our project.<br>. 
*/
public class MyMain {
	
	/**
	 * This function is used to test the divide and conquer algorithms.
	 */
	public static void test(){
		//1. We create extra variables for the tests
		
		// m1 = []
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		// m2 = [5,20,1,10]
		MyList<Integer> m2 = new MyDynamicList<Integer>();
		m2.addElement(0, 5); 
		m2.addElement(1, 20);
		m2.addElement(2, 1);
		m2.addElement(3, 10);

		// m3 = [5, 10, 20 ,50]
		MyList<Integer> m3 = new MyDynamicList<Integer>();
		m3.addElement(0, 5);
		m3.addElement(1, 10);
		m3.addElement(2, 20);
		m3.addElement(3, 50);

		//3. We create extra variables for the results		
		MyList<Integer> resM = null;
		
		//---------------------
		// TESTS
		//---------------------		

		//----------------------------
		//1. We test ChangeMaking_1
		//----------------------------
		System.out.println("\n----------- Test: ChangeMaking_1 -------------\n");

		ChangeMaking_1 ex1 = new ChangeMaking_1();

		System.out.println("==================== Problem 1 ====================");
		resM = ex1.solve(m1, 36);
		System.out.println();

        System.out.println("==================== Problem 2 ====================");
        resM = ex1.solve(m2, 36);
		System.out.println();

        System.out.println("==================== Problem 3 ====================");
		resM = ex1.solve(m2, 58);
		System.out.println();

        System.out.println("==================== Problem 4 ====================");
        resM = ex1.solve(m3, 37643);
        System.out.println();
		
		System.out.println();		

		//----------------------------
		//1. We test ChangeMaking_2
		//----------------------------
		System.out.println("\n----------- Test: ChangeMaking_2 -------------\n");

		ChangeMaking_2 ex2 = new ChangeMaking_2();

        System.out.println("==================== Problem 1 ====================");
		resM = ex2.solve(m1, 36);
		System.out.println();

        System.out.println("==================== Problem 2 ====================");
		resM = ex2.solve(m2, 36);
		System.out.println();

        System.out.println("==================== Problem 3 ====================");
		resM = ex2.solve(m2, 58);
		System.out.println();

        System.out.println("==================== Problem 4 ====================");
        resM = ex2.solve(m3, 37643);
        System.out.println();

        System.out.println();
		
	}
	
	/**
	 * Main Method.
	 * @param args: We will run the program parameter free, so do not worry about it.
	 */
	public static void main(String[] args) {
		test();
	}

}
