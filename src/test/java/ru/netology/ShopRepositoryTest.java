
package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netelogy.NotFoundException;
import ru.netelogy.Product;


public class ShopRepositoryTest {


    @Test
    public void removeById() {
        ShopRepository shop = new ShopRepository();

        Product item1 = new Product(1, "Кофе", 700);
        Product item2 = new Product(2, "Чай", 400);
        ;

        shop.add(item1);
        shop.add(item2);

        shop.removeById(1);

        Product[] expected = { item2 };
        Product[] actual = shop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByNotId() {
        ShopRepository shop = new ShopRepository();

        Product item1 = new Product(1, "Кофе", 700);

        shop.add(item1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeById(2);
        });
    }
}