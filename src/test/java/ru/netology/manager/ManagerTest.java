package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;
import ru.netology.products.manager.Manager;
import ru.netology.products.repository.Repository;

public class ManagerTest {
    Repository repo = new Repository();
    Manager mng = new Manager(repo);
    Product p1 = new Product(1, "product", 100);
    Product p2 = new Book(2, "bookname", 300, "authorOfTheBook");
    Product p3 = new Smartphone(3, "smartphone1", 100_000, "apple");
    Product p4 = new Smartphone(4, "smartphone2", 50_000, "bread");
    Product p5 = new Smartphone(5, "smartphone3", 10_000, "milk");

    //.add()
    @Test
    void shouldAddIntoEmptyRepoWithManager() {
        mng.add(p1);

        Product[] expected = {p1};
        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    void shouldAddIntoNonEmptyRepoWithManager() {
        mng.add(p1);
        mng.add(p2);
        mng.add(p3);
        mng.add(p4);
        mng.add(p5);

        Product[] er = {p1, p2, p3, p4, p5};
        assertArrayEquals(er, repo.findAll());
    }

    //.searchBy()

    @Test
    void shouldSearchInNonEmptyRepo() {
        mng.add(p1);
        mng.add(p4);
        mng.add(p3);
        mng.add(p5);

        Product[] er = {p4,p3,p5};
        Product[] ar = mng.searchBy("phone");
        assertArrayEquals(er, ar);

    }

    @Test
    void shouldSearchInEmptyRepo() {
        Product[] er = {};
        Product[] ar = mng.searchBy("smartphone");

        assertArrayEquals(er, ar);
    }

    @Test
    void shouldNotFindWithSearchByWrongKey() {
        mng.add(p1);
        mng.add(p2);
        mng.add(p3);
        mng.add(p4);
        mng.add(p5);

        Product[] er = {};
        Product[] ar = mng.searchBy("qwerty");
        assertArrayEquals(er, ar);
    }
}
