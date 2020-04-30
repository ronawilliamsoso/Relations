package com.example.relations.repository;

import com.example.relations.foreignKeyColumn.Cat;
import com.example.relations.foreignKeyColumn.Sheep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface SheepRepository extends JpaRepository<Sheep,Integer>,JpaSpecificationExecutor<Sheep>{

}