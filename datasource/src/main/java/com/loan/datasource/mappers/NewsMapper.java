package com.loan.datasource.mappers;

import com.loan.datasource.entities.News;
import com.loan.datasource.entities.NewsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    /**
     * 分页查询
     * @param start
     * @param end
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "msgType", column = "msg_type"),
            @Result(property = "title", column = "title"),
            @Result(property = "tag", column = "tag"),
//            @Result(property = "content", column = "content"),
//            @Result(property = "createTime", column = "create_time"),
//            @Result(property = "createBy", column = "create_by")
    })
    @Select("select id, msg_type, tag, title from news limit #{start},#{end}")
    List<News> selectByPage(@Param("start") int start, @Param("end") int end);


    /**
     * 根据id获取具体内容
     * @param id
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "msgType", column = "msg_type"),
            @Result(property = "title", column = "title"),
            @Result(property = "tag", column = "tag"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createBy", column = "create_by")
    })
    @Select("select * from news where id = #{id}")
    News selectById(@Param("id") long id);

}