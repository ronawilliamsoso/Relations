package com.example.relations.recrusion;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Wei
 * @date 25.05.20
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DerivedDrawPrize implements Serializable {

    @Id
    @Column( unique = true, nullable = false, precision = 11 )
    private Integer id;

    @Column(name="parent_draw_prize_id" )
    private Integer parentDrawPrizeId;

}
