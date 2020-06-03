package com.example.relations.controller;


import com.example.relations.compositeKey.DrawPeriodCutOff;
import com.example.relations.enums.PayMethod;
import com.example.relations.foreignKeyColumn.*;
import com.example.relations.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Wei
 * @date 04.04.20
 */

@RestController
@RequiredArgsConstructor
public class DrawPeriodCutOffController {


    private final DrawPeriodCutOffRepository drawPeriodCutOffRepository;


    @GetMapping( value = "/drawPeriodCutOff/getByMethod" )
    public void getOne(PayMethod method){

       List<DrawPeriodCutOff>  drawPeriodCutOff0 = drawPeriodCutOffRepository.findByPayMethod( method);

        List<DrawPeriodCutOff> drawPeriodCutOff1 =   drawPeriodCutOffRepository.findByCutOffAfter(new Date());

        List<DrawPeriodCutOff> drawPeriodCutOff2 =   drawPeriodCutOffRepository.findByCutOffAfterAndPayMethod(new Date(),  method);


        System.out.println("hhhhhhhh");


    }




}
