package com.example.relations.compositeKey;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wei
 * @date 27.05.20
 */


public class FlatMapTest implements Serializable {

    public static void main(String[] args) {

        List<String> teamIndia = Arrays.asList("A1", "A2", "A3");
        List<String> teamAustralia = Arrays.asList("B1", "B2", "B3");
        List<String> teamEngland = Arrays.asList("C1", "C2", "C3");


        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);

        List<String> flatMapList = playersInWorldCup2016.stream().flatMap(a->a.stream().map(b->b.toLowerCase())).collect(Collectors.toList());


        System.out.println("List of all Players using Java 8");
        System.out.println(flatMapList);
    }
}
