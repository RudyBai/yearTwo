import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    static void menuMethod() {

        ProductDatabase database = new ProductDatabase();
        ArrayList<Customer> customers = new ArrayList<>();

        boolean run = true;

        while (run) {
            System.out.println("" +
                    "1. Create a new phone.\n" +
                    "2. Create a new Customer.\n" +
                    "3. Search for a product by supplying the product ID.\n" +
                    "4. Display all products in the database.\n" +
                    "5. Allow a customer to order some products.\n" +
                    "6. Display all orders that a customer has made and all the products that are in a given order.\n" +
                    "7. Display all orders for a given product by supplying the product ID.\n" +
                    "8. Quit"
            );

            Scanner keyboard = new Scanner(System.in);

            int option = functions.parseOption(keyboard);

            //=========================================================

            switch (option) {
                case 1:

                    functions.addPhone(keyboard, database);

                    break;

                case 2:

                    functions.addCustomer(keyboard, customers);

                    break;

                case 3:

                    functions.getProductByID(keyboard, database);

                    break;

                case 4:

                    functions.displayAllProducts(database);

                    break;

                case 5:

                    functions.addOrderToCustomer(keyboard, customers, database);

                    break;

                case 6:

                    functions.displayCustomerOrders(keyboard, customers);

                    break;

                case 7:

                    functions.getOrdersByID(keyboard, customers, database);

                    break;
                case 8:
                    run = false;
                    break;
            }
        }
    }
}
