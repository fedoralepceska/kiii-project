package mk.ukim.finki.wtshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.wtshop.model.Category;
import mk.ukim.finki.wtshop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
