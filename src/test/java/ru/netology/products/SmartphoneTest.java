package ru.netology.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartphoneTest {
    Product p1 = new Product(1,"xz", 300);
    Product p2 = new Smartphone(2,"smartphone",30_000,"maple");

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
        assertTrue(p2.matches("phone"));
    }

    @Test
    void shouldReturnTrueFromThisConstr() {
        assertTrue(p2.matches("maple"));
    }
}
