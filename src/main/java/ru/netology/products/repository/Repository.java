package ru.netology.products.repository;

import ru.netology.products.Product;

/* Разработайте репозиторий, позволяющий сохранять Product'ы, получать все сохранённые Product'ы
 и удалять по id. Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров).*/
public class Repository {
    private Product[] storage = new Product[0];

    public Product[] getStorage() {
        return storage;
    }

    public void setStorage(Product[] storage) {
        this.storage = storage;
    }

    public void save(Product inputProduct) {
        Product[] tmp = new Product[storage.length + 1];
        System.arraycopy(storage, 0, tmp, 0, storage.length);
        tmp[tmp.length - 1] = inputProduct;
        storage = tmp;
    }

    public Product[] findAll() {
        return getStorage();
    }

    public void removeById(int valueOfId) {
        if (storage.length != 0) {
            Product[] tmp = new Product[storage.length - 1];
            int tmpIndex = 0;

            for (int i = 0; i < storage.length; i++) {
                if (storage[i].getId() != valueOfId) {
                    tmp[tmpIndex] = storage[i];
                    tmpIndex++;
                }
            }
            setStorage(tmp);
        }
    }
}
