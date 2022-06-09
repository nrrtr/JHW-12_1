package ru.netology.products;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BookTest {
    Product p1 = new Product(1,"not book",1000);
    Product p2 = new Book(2, "book",300,"Pushkin");

    @Test
    void shouldReturnFalseWithNoKeyword() {
        assertFalse(p1.matches("''"));
    }

    @Test
    void shouldReturnFalseWithWrongKey() {
        assertFalse(p1.matches("smartphone"));
    }

    @Test
    void shouldReturnTrueFromProductConstr() {
        assertTrue(p2.matches("book"));
    }

    @Test
    void shouldReturnTrueFromThisConstr() {
        assertTrue(p2.matches("Pushkin"));
    }
}
