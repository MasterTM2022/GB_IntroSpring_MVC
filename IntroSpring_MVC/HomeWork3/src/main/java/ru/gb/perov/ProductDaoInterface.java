package ru.gb.perov;

import java.util.List;

public interface ProductDaoInterface {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product save(Product product);
}
