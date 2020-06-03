package com.example.relations.services;

import com.example.relations.recrusion.DerivedDrawPrize;
import com.example.relations.repository.DerivedDrawPrizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @author Wei
 * @date 25.05.20
 */

@Service
@RequiredArgsConstructor
public class DerivedDrawPrizeService {
    private final DerivedDrawPrizeRepository derivedDrawPrizeRepository;

//    deleteDrawPrize
//1. check existence of drawPrize.Id
//2. check drawPrize.drawPeriod.status = OPEN
//3. if drawPrize.isParent
//    a. for each drawPrize.child call deleteDrawPrize
//4. if drawPrize.isChild
//    a. delete record in derived_draw_prize table
//5. delete record in draw_prize table


    public void deleteChain(Integer id) {

        derivedDrawPrizeRepository.findById(id).ifPresent(derivedDrawPrize -> {

            derivedDrawPrizeRepository.findAll(Example.of(DerivedDrawPrize.builder()
                    .parentDrawPrizeId(derivedDrawPrize.getId())
                    .build())).forEach(derivedDrawPrize1 -> {
                deleteChain(derivedDrawPrize1.getId());
            });
            derivedDrawPrizeRepository.delete(derivedDrawPrize);
        });


    }
}
