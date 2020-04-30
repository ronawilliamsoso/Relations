package com.example.relations.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.relations.foreignKeyColumn.Dog;


@Repository
public interface DogRepository extends JpaRepository<Dog,Integer>,JpaSpecificationExecutor<Dog>{

}