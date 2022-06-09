package ru.netology.products.manager;

import ru.netology.products.Product;
import ru.netology.products.repository.Repository;

public class Manager {
    private Repository repo;

    public Manager(Repository repository) {
        this.repo = repository;
    }

    public void add(Product inputProduct) {
        this.repo.save(inputProduct);
    }

    public boolean matches(Product product, String searchedStr) {
        return product.getName().contains(searchedStr);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
