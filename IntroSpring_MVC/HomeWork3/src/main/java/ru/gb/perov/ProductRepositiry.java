package ru.gb.perov;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositiry implements ProductDaoInterface{
    private List<Product> products;

    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product("bread", 100.0),
                new Product("milk", 11.5),
                new Product("eggs", 12.0),
                new Product("cheese", 12.5),
                new Product("butter", 13.0),
                new Product("cottage cheese", 13.5),
                new Product("sunflower oil", 14.0),
                new Product("flour", 14.5),
                new Product("salt", 15.0),
                new Product("sugar", 15.5)
        ));
    }
    public Product findById(Long id) {
        if (products == null) {
            init();
        }
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    public List<Product> findAll() {
        if (products == null) {
            init();
        }
        return products;
    }

    @Override
    public void deleteById(Long id) {
        if (products == null) {
            init();
        }
        products.remove(findById(id));
        products.forEach(System.out::println);
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    public List<Product> addProduct(String title, double cost) {
        if (products == null) {
            init();
        }
        Product newProduct = new Product(title, cost);
        products.add(newProduct);
        return products;
    }
}
