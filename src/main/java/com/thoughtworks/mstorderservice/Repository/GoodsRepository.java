package com.thoughtworks.mstorderservice.Repository;

import com.thoughtworks.mstorderservice.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    Optional<Goods> findById(Long id);
}
