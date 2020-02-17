import java.util.*;

class ProductDatabase {

    // Attributes
    private int numItems;
    private ArrayList<Product> productList;

    // Constructor
    ProductDatabase() {
        this.numItems = 0;
        this.productList = new ArrayList<>();
    }

    // Getters
    int getNumItems() {
        return numItems;
    }

    ArrayList<Product> getProductList() {
        return productList;
    }

    // Add Product
    void addProduct(Product parameterProduct) {
        this.productList.add(parameterProduct);
        this.numItems++;
    }

    // Remove Product
    void removeProduct(Product parameterProduct) {
        productList.remove(parameterProduct);
        this.numItems--;
    }

    // Return Product by ID
    Product getProductByID(int ID) {

        Product res = null;

        for (int i = 0; i < this.numItems; i++) {
            if (this.productList.get(i).getProductID() == ID) {
                res =  this.productList.get(i);
            }
        }
        return res;
    }
}
