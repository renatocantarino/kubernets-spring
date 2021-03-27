package com.cantarino.ms.repositories;

import com.cantarino.ms.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p.nome , p.preco from product  p inner join category c on p.category.id = c.id where c.id = :categoryId")
    List<Product> findByCategory(Long categoryId);
}
