package es.upm.miw.apaw_practice.adapters.mongodb.shop;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.out_ports.shop.ArticlePersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ArticlePersistenceMongodbIT {

    @Autowired
    private ArticlePersistence articlePersistence;

    @Test
    void testReadByBarcodeNotFound() {
        assertThrows(NotFoundException.class, () -> this.articlePersistence.readByBarcode(0L));
    }

    @Test
    void testBarcodeNotExist() {
        this.articlePersistence.assertBarcodeNotExist(0L);
    }

    @Test
    void testBarcodeNotExistConflict() {
        assertThrows(ConflictException.class, () -> this.articlePersistence.assertBarcodeNotExist(84003L));
    }

    @Test
    void testCreateAndRead() {
        Article article =
                new Article(6661001L, "art per", new BigDecimal("3.00"), "prov per");
        this.articlePersistence.create(article);
        Article articleBD = this.articlePersistence.readByBarcode(6661001L);
        assertEquals("art per", articleBD.getDescription());
        assertEquals(0, new BigDecimal("3.00").compareTo(articleBD.getPrice()));
        assertEquals("prov per", articleBD.getProvider());
        assertNotNull(articleBD.getRegistrationDate());
        assertNotNull(articleBD.getId());
    }

    @Test
    void testCreateAndUpdate() {
        Article article =
                new Article(6661002L, "art per", new BigDecimal("3.00"), "prov per");
        Article articleBD = this.articlePersistence.create(article);
        articleBD.setPrice(BigDecimal.TEN);
        this.articlePersistence.update(articleBD);
        articleBD = this.articlePersistence.readByBarcode(6661002L);
        assertEquals(0, BigDecimal.TEN.compareTo(articleBD.getPrice()));
    }

    @Test
    void testCreateConflict() {
        Article article =
                new Article(84003L, "art per", new BigDecimal("3.00"), "prov per");
        assertThrows(ConflictException.class, () -> this.articlePersistence.create(article));
    }
}
