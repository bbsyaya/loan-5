package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.CooperationTypeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shuttle on 6/25/17.
 */
public interface CooperationTypeRepository extends CrudRepository<CooperationTypeEntity, Long> {
}
