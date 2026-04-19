package spring.spring_practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spring_practice.models.Product;
import spring.spring_practice.repository.ProductRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
//    List<Product> products = new ArrayList<>( Arrays.asList(
//            new Product(101,"iphone 16",127000),
//            new Product(102,"Samsung s23",75000),
//            new Product(103,"Redmi Note 14 Pro", 39000)
//    ));

    public List<Product> getProducts(){
//        return products;
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
//        return products.stream()
//                .filter(p -> p.getId() == id)
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productRepo.findById(id).orElse(null);
    }

    public List<Product> addProduct(Product p){
        productRepo.save(p);
        return getProducts();
    }

//    public int getProductIndex(int p){
//        int i = 0;
//        for(int j = 0;j<products.size();j++){
//            if(products.get(j).getId()==p){
//                i = j;
//                break;
//            }
//        }
//        return i;
//    }

    public List<Product> updateProduct(Product p){
//        int i = getProductIndex(p.getId());
//        products.set(i,p);
        productRepo.save(p);
        return getProducts();
    }

    public List<Product> deleteProduct(int p){
//        int i = getProductIndex(p);
//        products.remove(i);
        productRepo.deleteById(p);
        return getProducts();
    }
}
