package mk.ukim.finki.wtshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.wtshop.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
