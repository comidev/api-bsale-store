package comidev.apibsale.utils;

import java.util.List;

import lombok.Getter;

@Getter
public class CustomPage<T> {
    private List<T> items;
    private boolean isLast;
    private boolean isEmpty;
    private boolean isFirst;
    private int totalPages;
    private int pageNumber;
    private long totalItems;

    public CustomPage(
            List<T> items,
            boolean isLast,
            boolean isEmpty,
            boolean isFirt,
            int totalPages,
            int pageNumber,
            long totalItems) {
        this.items = items;
        this.isLast = isLast;
        this.isEmpty = isEmpty;
        this.isFirst = isFirt;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.totalItems = totalItems;
    }
}
