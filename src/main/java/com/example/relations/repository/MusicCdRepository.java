package com.example.relations.repository;

import com.example.relations.twoEntitiesOneTable.Music;
import com.example.relations.twoEntitiesOneTable.model.MusicCd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei
 * @date 12.04.20
 */

@Repository
public interface MusicCdRepository extends JpaRepository<MusicCd,Long> {
}
