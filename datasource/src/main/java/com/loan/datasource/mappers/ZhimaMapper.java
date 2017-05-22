package com.loan.datasource.mappers;

import com.loan.datasource.entities.Zhima;
import com.loan.datasource.entities.ZhimaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZhimaMapper {
    int countByExample(ZhimaExample example);

    int deleteByExample(ZhimaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Zhima record);

    int insertSelective(Zhima record);

    List<Zhima> selectByExample(ZhimaExample example);

    Zhima selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Zhima record, @Param("example") ZhimaExample example);

    int updateByExample(@Param("record") Zhima record, @Param("example") ZhimaExample example);

    int updateByPrimaryKeySelective(Zhima record);

    int updateByPrimaryKey(Zhima record);
}