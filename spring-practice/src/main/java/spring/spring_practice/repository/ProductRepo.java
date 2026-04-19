package spring.spring_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.spring_practice.models.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
