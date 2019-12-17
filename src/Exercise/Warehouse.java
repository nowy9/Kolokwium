package Exercise;

import Exercise.Product;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Warehouse {
    Map<Integer, Product> products = new HashMap<>();
    int productId = products.size() + 1;
    public int add(){
        Scanner scanner = new Scanner(System.in);
        String productName;
        Integer amount;
        System.out.println("Podaj nazwę produktu:");
        productName = scanner.nextLine();
        System.out.println("Podaj ilość (sztuki):");
        amount = scanner.nextInt();
        Product product = new Product(productName, amount, LocalDate.now());
        products.put(productId, product);
        System.out.println("Utworzono produkt o identyfikatorze: " + productId);
        productId++;
        return productId;
    }
    public void delete_id (int productId){
       boolean exist =  products.containsKey(productId);
        if (exist == true){
            products.remove(productId);
            System.out.println("Usunięto produkt.");
        }
        else {
            System.out.println("Brak produktu o zadanym identyfikatorze.");
        }
    }
    public void show_id (int productId){
        boolean exist =  products.containsKey(productId);
        if (exist == true){
            System.out.println("Identyfikator produktu: " + productId);
            System.out.println("Nazwa produktu: " +  products.get(productId).getProductName());
            System.out.println("Data dodania: " + products.get(productId).getDate());
            System.out.println("Sztuk na magazynie: " + products.get(productId).getAmount());
        }
        else {
            System.out.println("Brak produktu o zadanym identyfikatorze.");
        }
    }
    public void show(){
        System.out.println("Produkty w magazynie: " + products.size());
        int allProductsAmount = 0;
        int theBiggestAmount = 0;
        int productIdWithTheBiggestAmount = 0;
        int theSmallestAmount = 0;
        int productIdWithTheSmallestAmount = 0;
        for (Product product : products.values()){
            allProductsAmount += products.get(productId).getAmount();
        }
        System.out.println("Sztuk: " + allProductsAmount);
        for (Product product : products.values()){
            if (products.get(productId).getAmount()<products.get(productId + 1).getAmount()){
                theBiggestAmount = products.get(productId + 1).getAmount();
                productIdWithTheBiggestAmount = productId + 1;
            }
            else {
                theBiggestAmount = products.get(productId).getAmount();
                productIdWithTheBiggestAmount = productId;
            }
        }
        System.out.println("Najwięcej sztuk produktu ("+ theBiggestAmount +"): " + products.get(productIdWithTheBiggestAmount).getProductName());

        for (Product product : products.values()){
            if (products.get(productId).getAmount()<products.get(productId + 1).getAmount()){
                theSmallestAmount = products.get(productId).getAmount();
                productIdWithTheSmallestAmount = productId;
            }
            else {
                theSmallestAmount = products.get(productId + 1).getAmount();
                productIdWithTheSmallestAmount = productId + 1;
            }
        }
        System.out.println("Najmniej sztuk produktu ("+ theSmallestAmount +"): " + products.get(productIdWithTheSmallestAmount).getProductName());

        System.out.println("Produkty: ");
        for (Product product : products.values()){
            System.out.println(product.getProductName() + "("+product.getAmount()+")");
        }

    }
}
