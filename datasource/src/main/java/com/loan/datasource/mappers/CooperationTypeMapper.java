package com.loan.datasource.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface CooperationTypeMapper {
    /**
     * 插入合作商的关系
     *
     * @param cid 合作商id
     * @param mid 模块id
     * @return
     * @throws Exception
     */
    @Insert("insert into cooperation_type values (#{cid}, #{mid})")
    @Options(useGeneratedKeys = true, keyProperty = "cooperation.id")
    int insert(@Param("cid") long cid, @Param("mid") long mid) throws Exception;
}