package com.example.relations.repository;

import com.example.relations.recrusion.DerivedDrawPrize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei
 * @date 25.05.20
 */

@Repository
public interface DerivedDrawPrizeRepository extends JpaRepository<DerivedDrawPrize, Integer> {
}
