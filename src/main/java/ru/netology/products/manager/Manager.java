package ru.netology.products.manager;

import ru.netology.products.Product;
import ru.netology.products.repository.Repository;

import java.security.PublicKey;


/* Разработайте менеджера, который умеет добавлять Product'ы в репозиторий
и осуществлять поиск по ним. Для этого вам нужно создать класс,
конструктор которого будет принимать параметром репозиторий,
 а также с методом publiс void add(Product product) и методом поиска (см. ниже).*/
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
