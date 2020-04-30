package com.example.relations.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.relations.foreignKeyColumn.Cat;


@Repository
public interface CatRepository extends JpaRepository<Cat,Integer>,JpaSpecificationExecutor<Cat>{

}