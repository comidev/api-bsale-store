package comidev.apibsale.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import comidev.apibsale.category.Category;
import comidev.apibsale.exceptions.notAcceptable.NotAcepptableException;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Page<Product> getProducts(int numPage, int limit) {
        return productRepo.findAll(PageRequest.of(numPage, limit));
    }

    public Page<Product> getProductsSort(String sortBy, String order, int numPage, int limit) {
        Direction direction = Direction.fromString(order);
        return productRepo.findAll(PageRequest.of(numPage, limit, Sort.by(direction, sortBy)));
    }

    public Page<Product> getProductByCategory(Long id, int numPage, int limit) {
        return productRepo.findByCategory(new Category(id), PageRequest.of(numPage, limit));
    }

    public Page<Product> getProductsByNameContaining(String infix, int numPage, int limit) {
        return productRepo.findByNameContaining(infix, PageRequest.of(numPage, limit));
    }

    public Page<Product> getProductsByDiscountBetween(int min, int max, int numPage, int limit) {
        if (min > max) {
            String message = "Min (" + min + ") > Max (" + max + ")";
            throw new NotAcepptableException(message);
        }
        final int MAX = getMaxDiscount();
        if (min > MAX || max < 0) {
            String message = "Min (" + min + ") es mayor a Max:" + MAX + " o Max (" + max + ") es menor a Min: 0";
            throw new NotAcepptableException(message);
        }
        return productRepo.findByDiscountBetween(min, max, PageRequest.of(numPage, limit));
    }

    public Page<Product> getProductsByPriceBetween(float min, float max, int numPage, int limit) {
        if (min > max) {
            String message = "Min (" + min + ") > Max (" + max + ")";
            throw new NotAcepptableException(message);
        }
        final float MAX = getMaxPrice();
        if (min > MAX || max < 0) {
            String message = "Min (" + min + ") es mayor a Max:" + MAX + " o Max (" + max + ") es menor a Min: 0";
            throw new NotAcepptableException(message);
        }
        return productRepo.findByPriceBetween(min, max, PageRequest.of(numPage, limit));
    }

    public Integer getMaxDiscount() {
        return productRepo.findMaxDiscount();
    }

    public Float getMaxPrice() {
        return productRepo.findMaxPrice();
    }
}
