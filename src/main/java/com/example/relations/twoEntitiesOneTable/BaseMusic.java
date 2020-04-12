package com.example.relations.twoEntitiesOneTable;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Wei
 * @date 12.04.20
 */

@MappedSuperclass
public abstract class BaseMusic {

}
