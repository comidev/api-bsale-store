package comidev.apibsale.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import comidev.apibsale.category.Category;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findByCategory(Category category, Pageable pageable);

    Page<Product> findByNameContaining(String infix, Pageable pageable);

    Page<Product> findByDiscountBetween(int min, int max, Pageable pageable);

    Page<Product> findByPriceBetween(float min, float max, Pageable pageable);

    @Query("SELECT MAX(price) FROM Product")
    Float findMaxPrice();

    @Query("SELECT MAX(discount) FROM Product")
    Integer findMaxDiscount();
}
