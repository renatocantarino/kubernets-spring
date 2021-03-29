package com.cantarino.ms.repositories;

import com.cantarino.ms.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop , Long> , ReportRepository {

    List<Shop> findAllByUserIdentifier(String userIdentifier);
    List<Shop> findAllByTotalGreaterThan(Float toal);
    List<Shop> findAllByDateGreaterThan(Date data);
}
