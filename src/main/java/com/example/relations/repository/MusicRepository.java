package com.example.relations.repository;

import com.example.relations.twoEntitiesOneTable.Music;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Wei
 * @date 12.04.20
 */

@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {
}
