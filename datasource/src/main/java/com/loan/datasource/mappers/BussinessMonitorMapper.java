package com.loan.datasource.mappers;

import com.loan.datasource.entities.BussinessMonitor;
import com.loan.datasource.entities.BussinessMonitorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BussinessMonitorMapper {
    int countByExample(BussinessMonitorExample example);

    int deleteByExample(BussinessMonitorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BussinessMonitor record);

    int insertSelective(BussinessMonitor record);

    List<BussinessMonitor> selectByExample(BussinessMonitorExample example);

    BussinessMonitor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BussinessMonitor record, @Param("example") BussinessMonitorExample example);

    int updateByExample(@Param("record") BussinessMonitor record, @Param("example") BussinessMonitorExample example);

    int updateByPrimaryKeySelective(BussinessMonitor record);

    int updateByPrimaryKey(BussinessMonitor record);
}