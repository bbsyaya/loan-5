package com.loan.datasource.mappers;

import com.loan.datasource.entities.Cooperation;
import com.loan.datasource.entities.CooperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CooperationMapper {
    int countByExample(CooperationExample example);

    int deleteByExample(CooperationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cooperation record);

    int insertSelective(Cooperation record);

    List<Cooperation> selectByExample(CooperationExample example);

    Cooperation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Cooperation record, @Param("example") CooperationExample example);

    int updateByExample(@Param("record") Cooperation record, @Param("example") CooperationExample example);

    int updateByPrimaryKeySelective(Cooperation record);

    int updateByPrimaryKey(Cooperation record);
}