package comidev.apibsale.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import comidev.apibsale.category.Category;
import lombok.Getter;

@Getter
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "url_image")
    private String urlImage;
    private Float price;
    private Integer discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;

    @Override
    public String toString() {
        return "Product [category=" + category + ", discount=" + discount + ", id=" + id + ", name=" + name + ", price="
                + price + ", urlImage=" + urlImage + "]";
    }
}
