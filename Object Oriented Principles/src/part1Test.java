public class part1Test {
    public static void main(String[] args) {

        // Test cases were beyond me at time of writing so I'm gonna pretend they still are

        Phone phone1 = new Phone(
                "iPhone 6",
                "The sixth generation of the Apple iPhone.",
                300.00,
                "Apple",
                "iPhone 6",
                256.00
        );
        Phone phone2 = new Phone(
                "Samsung Galaxy S8",
                "The eight generation of the Galaxy S series by Samsung.",
                400,
                "Samsung",
                "Galaxy S8",
                128.00
        );

        int nice = 69;

        TV tv1 = new TV(
                "Samsung Brand New TV 8K Great Amazing WOW",
                "Simply great 2/10 -IGN",
                10000.00,
                "Samsung",
                68,
                "LCD",
                false
        );

        TV tv2 = new TV(
                "Apple TV",
                "Not sure if this exists",
                20000.00,
                "Apple",
                nice,
                "MicroLED",
                true

        );

        ProductDatabase database = new ProductDatabase();

        database.addProduct(phone1);
        database.addProduct(phone2);
        database.addProduct(tv1);
        database.addProduct(tv2);


        Customer Mary = new Customer(
                "Mary"
        );
        Order order1 = new Order(phone1, 12);
        Order order2 = new Order(phone2, 1);
        Order order3 = new Order(tv1, 3);
        Order order4 = new Order(tv2, 1);
        Mary.addOrder(order1);
        Mary.addOrder(order2);
        Mary.addOrder(order3);
        Mary.addOrder(order4);

        database.removeProduct(tv2);

        Menu.menuMethod();

    }
}
