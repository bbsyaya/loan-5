package com.loan.datasource.mappers;

import com.loan.datasource.entities.Module;
import com.loan.datasource.entities.ModuleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModuleMapper {
    int countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    /**
     * 获取首页显示的 moudule
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "sort", column = "sort"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "index", column = "index"),
            @Result(property = "logo", column = "logo")
    })
    @Select("select * from `module` where `enabled`= #{enabled} and `index`=#{index}")
    List<Module> getModuleIndex(@Param("enabled") int enabled,@Param("index") int index);
}