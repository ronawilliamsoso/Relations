package com.example.relations.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.relations.foreignKeyColumn.Pig;


@Repository
public interface PigRepository extends JpaRepository<Pig,Integer>,JpaSpecificationExecutor<Pig>{

}