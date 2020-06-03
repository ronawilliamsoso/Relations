package com.example.relations.repository;

import com.example.relations.compositeKey.CutOffPk;
import com.example.relations.compositeKey.DrawPeriodCutOff;
import com.example.relations.enums.PayMethod;
import com.example.relations.recrusion.DerivedDrawPrize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Wei
 * @date 25.05.20
 */

@Repository
public interface DrawPeriodCutOffRepository extends JpaRepository<DrawPeriodCutOff, CutOffPk> {

//    List<Book> findByTitleContainsOrderByTitleAsc(String title);
//
//    List<Book> findFirst5ByTitleOrderByTitleAsc(String title);

    List<DrawPeriodCutOff> findByPayMethod(PayMethod payMethod);

    List<DrawPeriodCutOff>     findByCutOffAfter(Date nowDate);

    List<DrawPeriodCutOff>     findByCutOffAfterAndPayMethod(Date nowDate,PayMethod payMethod);




}
