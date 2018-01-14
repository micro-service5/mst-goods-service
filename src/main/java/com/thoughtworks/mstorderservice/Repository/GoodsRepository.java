package com.thoughtworks.mstorderservice.Repository;

import com.thoughtworks.mstorderservice.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
