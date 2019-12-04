import java.util.ArrayList;
import java.util.Scanner;

public class HeapEater {
    public static void main (String[] args) {
        ArrayList<Car> carArrayList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        while (true) {
            carArrayList.add(new Car("A", "A", "A", 1, 1));
            System.out.println(carArrayList.size());
        }
    }
}
