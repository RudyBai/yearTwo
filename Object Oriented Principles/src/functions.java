import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class functions {

    /**
     * This function handles taking in an integer between 1 and 8 from the user and pass it back to the menu function
     *
     * @param keyboard : import scanner to not generate new one
     * @return option : the option integer is sued by menu to decide which function the user wishes to run
     */
    static int parseOption(Scanner keyboard) {
        int option = 0;
        do {
            System.out.println("Please enter an option between 1 and 8 : ");
            try {
                option = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Must be an integer!");
                System.out.println();
                break;
            }
            keyboard.nextLine();
        } while (option < 1 || option > 8);
        return option;
    }

    //==============
    //=== CASE 1 ===
    //==============

    /**
     * This function adds a phone object to the menu's product database
     *
     * @param keyboard : import scanner to not generate new one
     * @param database : the product database that menu is working on
     */
    static void addPhone(Scanner keyboard, ProductDatabase database) {

        // Name
        System.out.print("Please enter the name of the product : ");
        String productName = keyboard.nextLine();
        System.out.println();

        // Description
        System.out.print("Please enter the description of the product : ");
        String description = keyboard.nextLine();
        System.out.println();

        // Price
        double price = 0;
        while (price == 0) {
            System.out.print("Please enter the price of the product : ");
            try {
                price = keyboard.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Must be an integer!");
                System.out.println();
                keyboard.next();
            }
        }


        keyboard.nextLine();
        System.out.println();

        // Make
        System.out.print("Please enter the make of the product : ");
        String make = keyboard.nextLine();
        System.out.println();

        // Model
        System.out.print("Please enter the model of the product : ");
        String model = keyboard.nextLine();
        System.out.println();

        // Storage Space
        System.out.print("Please enter the storage space of the product : ");
        double storageSpace = keyboard.nextDouble();
        keyboard.nextLine();
        System.out.println();

        database.addProduct(new Phone(productName, description, price, make, model, storageSpace));

    }

    //==============
    //=== CASE 2 ===
    //==============

    /**
     * This function adds a customer object to the menu's customer ArrayList
     *
     * @param keyboard  : import scanner to not generate new one
     * @param customers : import the customer array list we are going to edit
     */
    static void addCustomer(Scanner keyboard, ArrayList<Customer> customers) {
        // Name
        System.out.print("Please enter the name of the customer : ");
        String customerName = keyboard.nextLine();
        System.out.println();

        customers.add(new Customer(customerName));
    }

    //==============
    //=== CASE 3 ===
    //==============

    /**
     * This function performs the print function of an object in the product database.
     * The product depends on the ID provided by the user.
     *
     * @param keyboard : import scanner to not generate new one
     * @param database : the product database the menu is working on
     */
    static void getProductByID(Scanner keyboard, ProductDatabase database) {

        // ProductID
        int productID = -1;
        while (productID == -1) {
            System.out.print("Please enter the productID : ");
            try {
                productID = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Must be an integer!");
                System.out.println();
                keyboard.next();
            }
        }

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //ProductID out of bounds
        if (productID > database.getProductList().size() - 1) {
            scenario = 1;
        } else {
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("Product Index out od bounds");
                return;
            case 2:
                for (int i = 0; i < database.getNumItems(); i++) {
                    if (database.getProductList().get(i).getProductID() == productID) {
                        database.getProductList().get(i).print();
                        System.out.println();
                    }
                }
                break;
        }
    }

    //==============
    //=== CASE 4 ===
    //==============

    /**
     * Displays all products in the menu's database.
     *
     * @param database : the product database the menu is working on
     */
    static void displayAllProducts(ProductDatabase database) {
        System.out.println();
        for (Product product : database.getProductList()) {
            product.print();
            System.out.println();
        }
    }

    //==============
    //=== CASE 5 ===
    //==============

    /**
     *
     * This function takes in a Customer and instantiates a product object in the Customer's orders ArrayList.
     *
     * @param keyboard  : import scanner to not generate new one
     * @param customers : the array list of customers the menu is working on
     * @param database  : the product database the menu is working on
     */
    static void addOrderToCustomer(Scanner keyboard, ArrayList<Customer> customers, ProductDatabase database) {
        boolean run = true;
        while (run) {
            // Print all customers
            for (int i = 0; i < customers.size(); i++)
                System.out.println(i + ". " + customers.get(i).getName());

            // Customer
            int customerIndex = -1;
            while (customerIndex == -1) {
                System.out.print("Please enter the Customer Index : ");
                try {
                    customerIndex = keyboard.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Must be an integer!");
                    System.out.println();
                    keyboard.next();
                }
            }

            //-----------------------------
            // I. SCENARIO IDENTIFICATION
            //-----------------------------
            int scenario;
            //Customer index out of bounds
            if (customerIndex >= customers.size()) {
                scenario = 1;
            } else {
                scenario = 2;
            }

            //-----------------------------
            // II. SCENARIO IMPLEMENTATION
            //-----------------------------
            switch (scenario) {
                case 1:
                    System.out.println("Customer Index out od bounds.\n");
                    return;
                case 2:
                    // ProductID

                    //Print all Products
                    for (int i = 0; i < database.getProductList().size(); i++) {
                        System.out.println(i + ". " + database.getProductList().get(i).getName());
                    }

                    int productID = -1;
                    while (productID == -1) {
                        System.out.print("Please enter the productID : ");
                        try {
                            productID = keyboard.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println();
                            System.out.println("Must be an integer!");
                            System.out.println();
                            keyboard.next();
                        }
                    }

                    //-----------------------------
                    // I. SCENARIO IDENTIFICATION
                    //-----------------------------
                    //ProductID out of bounds
                    if (productID >= database.getProductList().size()) {
                        scenario = 1;
                    } else {
                        scenario = 2;
                    }
                    //-----------------------------
                    // II. SCENARIO IMPLEMENTATION
                    //-----------------------------
                    switch (scenario) {
                        case 1:
                            System.out.println("Product ID out od bounds.\n");
                            return;
                        case 2:
                            int quantity = -1;
                            while (quantity == -1) {
                                System.out.print("Please enter the quantity of the product : ");
                                try {
                                    quantity = keyboard.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println();
                                    System.out.println("Must be an integer!");
                                    System.out.println();
                                    keyboard.next();
                                }
                            }

                            Customer customer = customers.get(customerIndex);

                            Order order = new Order(database.getProductByID(productID), quantity);

                            customer.addOrder(order);
                    }
            }
            System.out.println("Would you like to add another product? [y/n] : ");
            char cont;
            do {
                cont = keyboard.next().charAt(0);
            } while (cont != 'y' && cont != 'n');

            if (cont != 'y') {
                run = false;
            }
        }
    }

    /**
     * Displays all orders a customer has made
     *
     * @param keyboard  : import scanner to not generate new one
     * @param customers : the array list of customers the menu is working on
     */
    //==============
    //=== CASE 6 ===
    //==============
    static void displayCustomerOrders(Scanner keyboard, ArrayList<Customer> customers) {
        // Print all customers
        for (int i = 0; i < customers.size(); i++)
            System.out.println(i + ". " + customers.get(i).getName());

        // Customer
        System.out.print("Please enter the index of the customer : ");
        int customerIndex = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println();

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //Customer index out of bounds
        if (customerIndex >= customers.size()) {
            scenario = 1;
        } else {
            scenario = 2;
        }

        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            case 1:
                System.out.println("Customer Index out od bounds.\n");
                return;
            case 2:
                for (int i = 0; i < customers.get(customerIndex).getOrders().size(); i++) {
                    System.out.println(customers.get(customerIndex).getName());
                    customers.get(customerIndex).getOrders().get(i).print();
                    System.out.println();
                }
        }
    }

    //==============
    //=== CASE 7 ===
    //==============

    /**
     * Displays all customers who have made an order which includes a product of a specified ID
     *
     * @param keyboard  : import scanner to not generate new one
     * @param customers : the array list of customers the menu is working on
     * @param database  : the product database the menu is working on
     */
    static void getOrdersByID(Scanner keyboard, ArrayList<Customer> customers, ProductDatabase database) {

        //Print all Products
        for (int i = 0; i < database.getProductList().size(); i++) {
            System.out.println(i + ". " + database.getProductList().get(i).getName());
        }

        // ProductID
        int productID = -1;
        while (productID == -1) {
            System.out.print("Please enter the productID : ");
            try {
                productID = keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Must be an integer!");
                System.out.println();
                keyboard.next();
            }
        }

        //-----------------------------
        // I. SCENARIO IDENTIFICATION
        //-----------------------------
        int scenario;
        //ProductID out of bounds
        if (productID >= database.getProductList().size()) {
            scenario = 1;
        } else {
            scenario = 2;
        }
        //-----------------------------
        // II. SCENARIO IMPLEMENTATION
        //-----------------------------
        switch (scenario) {
            // Quantity
            case 1:
                System.out.println("Product ID out od bounds.\n");
                return;
            case 2:
                for (Customer customer : customers) {
                    for (Order order : customer.getOrders()) {
                        if (order.getProduct().getProductID() == productID) {
                            System.out.println("Customer : " + customer.getName());
                            System.out.println("Product : " + order.getProduct().getName());
                            System.out.println("Quantity : " + order.getQuantity());
                            System.out.println();
                        }
                    }
                }
        }
    }
}
