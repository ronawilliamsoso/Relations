package com.example.relations.controller;


import com.example.relations.foreignKeyColumn.Cat;
import com.example.relations.foreignKeyColumn.Dog;
import com.example.relations.foreignKeyColumn.Master;
import com.example.relations.foreignKeyColumn.Pig;
import com.example.relations.foreignKeyColumn.Sheep;
import com.example.relations.repository.CatRepository;
import com.example.relations.repository.DogRepository;
import com.example.relations.repository.MasterRepository;
import com.example.relations.repository.PigRepository;
import com.example.relations.repository.SheepRepository;
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
    private final SheepRepository sheepRepository;


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
        Master master = masterRepository.findById(id).get();
        catRepository.findOne(Example.of(Cat.builder().master(master).build()));
//
//        select
//        cat0_.master_id as master_i1_2_,
//                cat0_.cat_gender as cat_gend2_2_,
//        cat0_.cat_name as cat_name3_2_
//                from
//        cat cat0_
//        inner join
//        master master1_
//        on cat0_.master_id=master1_.master_id
//        where
//        master1_.master_id=1
//        and master1_.address=?
//        and master1_.master_name=?

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

    @GetMapping( value = "/foreignKeyKolumn/getSheep" )
    public void getSheep(Integer id){

        Master master = masterRepository.findById(id).get();

//        Hibernate:
//        select
//        master0_.master_id as master_i1_6_0_,
//                master0_.address as address2_6_0_,
//        master0_.master_name as master_n3_6_0_
//                from
//        master master0_
//        where
//        master0_.master_id=?
        sheepRepository.findOne(Example.of(Sheep.builder().master(master).build()));
//        Hibernate:
//        select
//        sheep0_.master_id as master_i1_10_,
//                sheep0_.sheep_gender as sheep_ge2_10_,
//        sheep0_.sheep_name as sheep_na3_10_
//                from
//        sheep sheep0_
//        inner join
//        master master1_
//        on sheep0_.master_id=master1_.master_id
//        where
//        master1_.master_id=1
//        and master1_.master_name=?
//        and master1_.address=?
//        Hibernate:
//        select
//        dog0_.master_id as master_i1_3_0_,
//                dog0_.dog_gender as dog_gend2_3_0_,
//        dog0_.dog_name as dog_name3_3_0_
//                from
//        dog dog0_
//        where
//        dog0_.master_id=?
       Sheep sheep= sheepRepository.findOne(Example.of(Sheep.builder().id(id).build())).get();

//
//        Hibernate:
//        select
//        sheep0_.master_id as master_i1_10_,
//                sheep0_.sheep_gender as sheep_ge2_10_,
//        sheep0_.sheep_name as sheep_na3_10_
//                from
//        sheep sheep0_
//        where
//        sheep0_.master_id=1
//        Hibernate:
//        select
//        dog0_.master_id as master_i1_3_0_,
//                dog0_.dog_gender as dog_gend2_3_0_,
//        dog0_.dog_name as dog_name3_3_0_
//                from
//        dog dog0_
//        where
//        dog0_.master_id=?
       Dog dog = sheep.getDog();

//        Hibernate:
//        select
//        sheep0_.master_id as master_i1_10_,
//                sheep0_.sheep_gender as sheep_ge2_10_,
//        sheep0_.sheep_name as sheep_na3_10_
//                from
//        sheep sheep0_
//        where
//        sheep0_.master_id=1

        sheepRepository.findById(id);

        // this one is the same as the other one

    }


}
