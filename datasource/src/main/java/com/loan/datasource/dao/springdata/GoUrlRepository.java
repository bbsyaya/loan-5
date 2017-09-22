package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.AdminEntity;
import com.loan.datasource.entities.jpa.GoUrlEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description: 管理员控制类
 * @author: shuttle
 * @date: 2017-09-14 6:49 PM
 * @company: 北京鼎力创世科技有限公司
 */
public interface GoUrlRepository extends CrudRepository<GoUrlEntity, Long> {
}
