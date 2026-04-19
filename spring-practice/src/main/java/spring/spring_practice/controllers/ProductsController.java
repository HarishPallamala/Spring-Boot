package spring.spring_practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spring_practice.models.Product;
import spring.spring_practice.repository.ProductRepo;
import spring.spring_practice.services.ProductService;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;

    // by default requestMapping is Get mapping,
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/products")
    public List<Product> addProduct(@RequestBody Product product){
        return  productService.addProduct(product);
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
         return productService.getProductById(id);
    }

    @PutMapping("/products")
    public List<Product> updateProduct(@RequestBody Product product){
        return  productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public List<Product> deleteProduct(@PathVariable int id){
        return  productService.deleteProduct(id);
    }
}
