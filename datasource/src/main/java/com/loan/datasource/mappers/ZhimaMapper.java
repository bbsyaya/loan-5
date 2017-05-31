package com.loan.datasource.mappers;

import com.loan.datasource.entities.Zhima;

public interface ZhimaMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Zhima record);

    int insertSelective(Zhima record);

    Zhima selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Zhima record);

    int updateByPrimaryKey(Zhima record);
}