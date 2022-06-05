package comidev.apibsale.utils;

import java.util.List;

import org.springframework.data.domain.Page;

import comidev.apibsale.product.Product;

public class Mapper {
    public static CustomPage<Product> createProductPage(Page<Product> page) {
        List<Product> items = page.getContent();
        boolean isLast = page.isLast();
        boolean isEmpty = page.isEmpty();
        boolean isFirt = page.isFirst();
        int totalPages = page.getTotalPages();
        int pageNumber = page.getNumber();
        long totalItems = page.getTotalElements();
        return new CustomPage<Product>(items, isLast, isEmpty,
                isFirt, totalPages, pageNumber, totalItems);
    }
}
