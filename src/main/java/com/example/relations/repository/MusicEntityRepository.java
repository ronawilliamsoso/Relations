package com.example.relations.repository;

import com.example.relations.twoEntitiesOneTable.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wei
 * @date 12.04.20
 */

@Repository
public interface MusicEntityRepository extends JpaRepository<Music,Long> {
}
