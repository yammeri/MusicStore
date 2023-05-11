package repositories;

import entities.Category;
import entities.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository productRepository = new ProductRepository();

    @Test
    void get() {
        //проверяем, что вернёт null для заведомо несуществующего айдишника
        Product testProduct = productRepository.get(Long.MAX_VALUE);
        assertNull(testProduct);

        //добавить тестовый объект с заведомо несуществующим айдишником, проверить, что вернет не null, удалить объект
        testProduct = new Product(
                Long.MAX_VALUE,
                Long.MAX_VALUE,
                Category.GUITARS,
                "test_name",
                Integer.MAX_VALUE,
                BigDecimal.ONE);

        productRepository.save(testProduct);
        testProduct = productRepository.get(Long.MAX_VALUE);
        assertNotNull(testProduct);

        productRepository.extract(Long.MAX_VALUE);
    }

    @Test
    void save() {
        //добавить тестовый объект с заведомо несуществующим айдишником, проверить, что он добавился, удалить объект
        Product testProduct = new Product(
                Long.MAX_VALUE,
                Long.MAX_VALUE,
                Category.GUITARS,
                "test_name",
                Integer.MAX_VALUE,
                BigDecimal.ONE);

        Boolean isSaved = productRepository.save(testProduct);
        assertTrue(isSaved);

        //проверить, что невозможно добавить объект по такому же айдишнику
        isSaved = productRepository.save(testProduct);
        assertFalse(isSaved);

        productRepository.extract(Long.MAX_VALUE);

        //проверить, что невозможно вставить объект с параметрами, который не подходят по условиями в базе
        //???
    }

    @Test
    void extract() {
        //добавить тестовый объект с заведомо несуществующим айдишником, удалить объект, проверить, что он удалился
        Product testProduct = new Product(
                Long.MAX_VALUE,
                Long.MAX_VALUE,
                Category.GUITARS,
                "test_name",
                Integer.MAX_VALUE,
                BigDecimal.ONE);

        productRepository.save(testProduct);
        Boolean isExtracted = productRepository.extract(Long.MAX_VALUE);
        assertTrue(isExtracted);

        //проверить, что невозможно удалить заведомо не существующий объект
        isExtracted = productRepository.extract(Long.MAX_VALUE);
        assertFalse(isExtracted);
    }
}