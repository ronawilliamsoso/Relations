package com.example.relations.controller;


import com.example.relations.foreignKeyColumn.Cat;
import com.example.relations.foreignKeyColumn.Dog;
import com.example.relations.foreignKeyColumn.Master;
import com.example.relations.foreignKeyColumn.Pig;
import com.example.relations.repository.CatRepository;
import com.example.relations.repository.DogRepository;
import com.example.relations.repository.MasterRepository;
import com.example.relations.repository.PigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wei
 * @date 04.04.20
 */

@RestController
@RequiredArgsConstructor
public class ForeignKeyKolumnController {


    private final CatRepository catRepository;
    private final DogRepository dogRepository;
    private final MasterRepository masterRepository;
    private final PigRepository pigRepository;


    @GetMapping( value = "/foreignKeyKolumn/getPig" )
    public void getPig(Integer id){
       pigRepository.findOne(Example.of(Pig.builder().master(Master.builder().masterId(id).build()).build()));

//
//        Hibernate:
//        select
//        pig0_.master_id as master_i1_9_,
//                pig0_.pig_gender as pig_gend2_9_,
//        pig0_.pig_name as pig_name3_9_
//                from
//        pig pig0_
//        inner join
//        master master1_
//        on pig0_.master_id=master1_.master_id
//        where
//        master1_.master_id=1

        pigRepository.findById(id);

    }

    @GetMapping( value = "/foreignKeyKolumn/getDog" )
    public void getDog(Integer id){
        dogRepository.findOne(Example.of(Dog.builder().masterId(id).build()));

//        Hibernate:
//        select
//        dog0_.master_id as master_i1_3_,
//                dog0_.dog_gender as dog_gend2_3_,
//        dog0_.dog_name as dog_name3_3_
//                from
//        dog dog0_
//        where
//        dog0_.master_id=1
//        Hibernate:
//        select
//        master0_.master_id as master_i1_6_0_,
//                master0_.address as address2_6_0_,
//        master0_.master_name as master_n3_6_0_
//                from
//        master master0_
//        where
//        master0_.master_id=?

        dogRepository.findById(id);

    }

    @GetMapping( value = "/foreignKeyKolumn/getCat" )
    public void getCat(Integer id){
        catRepository.findOne(Example.of(Cat.builder().masterId(id).build()));

//        Hibernate:
//        select
//        cat0_.master_id as master_i1_2_,
//                cat0_.cat_gender as cat_gend2_2_,
//        cat0_.cat_name as cat_name3_2_
//                from
//        cat cat0_
//        where
//        cat0_.master_id=1

        catRepository.findById(id);

        // this one is equal with the one above.

    }


}
