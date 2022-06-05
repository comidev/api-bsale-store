package comidev.apibsale.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comidev.apibsale.utils.CustomPage;
import comidev.apibsale.utils.Descuento;
import comidev.apibsale.utils.Mapper;
import comidev.apibsale.utils.Precio;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<CustomPage<Product>> getProducts(
            @RequestParam(name = "numPage", defaultValue = "0") int numPage,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity.ok(Mapper.createProductPage(productService.getProducts(numPage, limit)));
    }

    @GetMapping("/sort")
    public ResponseEntity<CustomPage<Product>> getProductsSort(
            @RequestParam(name = "by") String sortBy,
            @RequestParam(name = "order") String order,
            @RequestParam(name = "numPage", defaultValue = "0") int numPage,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity
                .ok(Mapper.createProductPage(productService.getProductsSort(sortBy, order, numPage, limit)));
    }

    @GetMapping("/name")
    public ResponseEntity<CustomPage<Product>> getProductsByNameContaining(
            @RequestParam(name = "name") String infix,
            @RequestParam(name = "numPage", defaultValue = "0") int numPage,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity
                .ok(Mapper.createProductPage(productService.getProductsByNameContaining(infix, numPage, limit)));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<CustomPage<Product>> getProductByCategory(
            @PathVariable("id") Long id,
            @RequestParam(name = "numPage", defaultValue = "0") int numPage,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity.ok(Mapper.createProductPage(productService.getProductByCategory(id, numPage, limit)));
    }

    @GetMapping("/descuentos")
    public ResponseEntity<CustomPage<Product>> getProductsByDiscountBetween(
            @RequestParam(name = "min", defaultValue = "0") Integer min,
            @RequestParam(name = "max", defaultValue = "100") Integer max,
            @RequestParam(name = "numPage", defaultValue = "0") int numPage,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity
                .ok(Mapper.createProductPage(productService.getProductsByDiscountBetween(min, max, numPage, limit)));
    }

    @GetMapping("/precios")
    public ResponseEntity<CustomPage<Product>> getProductsByPriceBetween(
            @RequestParam(name = "min", defaultValue = "0") Float min,
            @RequestParam(name = "max", defaultValue = "100000") Float max,
            @RequestParam(name = "numPage", defaultValue = "0") int numPage,
            @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity
                .ok(Mapper.createProductPage(productService.getProductsByPriceBetween(min, max, numPage, limit)));
    }

    @GetMapping("/descuentos/mayor")
    public ResponseEntity<Descuento> getDescuentoMayor() {
        return ResponseEntity.ok(new Descuento(productService.getMaxDiscount()));
    }

    @GetMapping("/precios/mayor")
    public ResponseEntity<Precio> getPrecioMayor() {
        return ResponseEntity.ok(new Precio(productService.getMaxPrice()));
    }
}
