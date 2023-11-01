package com.example.jpa_restexam.jpatest.relation;

import com.example.jpa_restexam.product.model.Category;
import com.example.jpa_restexam.product.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class CategoryEntityTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Disabled
    void test(){
        CategoryEntity categoryEntity1 = new CategoryEntity("CatName1", "Info1");
        CategoryEntity categoryEntity2 = new CategoryEntity("CatName2", "Info2");
        CategoryEntity categoryEntity3 = new CategoryEntity("CatName3", "Info3");
        ProductEntity productEntity1 = new ProductEntity("PrdName1", "PrdCompany1", "PrdPrice1", categoryEntity1);
        ProductEntity productEntity2 = new ProductEntity("PrdName2", "PrdCompany2", "PrdPrice2", categoryEntity1);
        ProductEntity productEntity3 = new ProductEntity("PrdName3", "PrdCompany3", "PrdPrice3", categoryEntity2);
        ProductEntity productEntity4 = new ProductEntity("PrdName4", "PrdCompany4", "PrdPrice4", categoryEntity2);
        ProductEntity productEntity5 = new ProductEntity("PrdName5", "PrdCompany5", "PrdPrice5", categoryEntity3);
        entityManager.persist(categoryEntity1);
        entityManager.persist(categoryEntity2);
        entityManager.persist(categoryEntity3);
        entityManager.persist(productEntity1);
        entityManager.persist(productEntity2);
        entityManager.persist(productEntity3);
        entityManager.persist(productEntity4);
        entityManager.persist(productEntity5);
        entityManager.flush();
        entityManager.clear();
        List<ProductEntity> selectPFromProductEntityP = entityManager.createQuery("SELECT P FROM Product P", ProductEntity.class).getResultList();
        for (ProductEntity pe:selectPFromProductEntityP
             ) {
            System.out.println(pe.toString());
        }
    }

    @Test
    void test2(){
        Category categoryEntity1 = new Category("CatName1", "Info1");
        Category categoryEntity2 = new Category("CatName2", "Info2");
        Category categoryEntity3 = new Category("CatName3", "Info3");
        Product productEntity1 = new Product("PrdName1", "PrdCompany1", 100, categoryEntity1);
        Product productEntity2 = new Product("PrdName2", "PrdCompany2", 200, categoryEntity1);
        Product productEntity3 = new Product("PrdName3", "PrdCompany3", 300, categoryEntity2);
        Product productEntity4 = new Product("PrdName4", "PrdCompany4", 400, categoryEntity2);
        Product productEntity5 = new Product("PrdName5", "PrdCompany5", 500, categoryEntity3);
        entityManager.persist(categoryEntity1);
        entityManager.persist(categoryEntity2);
        entityManager.persist(categoryEntity3);
        entityManager.persist(productEntity1);
        entityManager.persist(productEntity2);
        entityManager.persist(productEntity3);
        entityManager.persist(productEntity4);
        entityManager.persist(productEntity5);
        entityManager.flush();
        entityManager.clear();
        List<Product> selectPFromProductEntityP = entityManager.createQuery("SELECT P FROM Product P", Product.class).getResultList();
        for (Product pe:selectPFromProductEntityP
        ) {
            System.out.println(pe.toString());
        }
    }
}