package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            Product temp = products[i];
            products[i] = products[i + 1];
            products[i + 1] = temp;
        }
        products[products.length - 1] = null;
        return products;
    }
}
