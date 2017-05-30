package com.loan.datasource.mappers;

import com.loan.datasource.entities.Cooperation;
import com.loan.datasource.entities.CooperationExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    /**
     * 插入后获取自增长的id
     * @param moduleId
     * @param start
     * @param end
     * @return
     */
//    @Insert("INSERT INTO api(component, clientApi, scribeDescribe, clientApiVersion, invokeTimeout, authType, sessionRequire, openType) VALUES(#{api.component}, #{api.clientApi}, #{api.scribeDescribe}, #{api.clientApiVersion}, #{api.invokeTimeout}, #{api.authType}, #{api.sessionRequire}, #{api.openType})")
//    @Options(useGeneratedKeys = true, keyProperty = "api.apiId") //此出设置将自增长的id赋值对象
//    void add(@Param("api") Api api);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "appName", column = "app_name"),
            @Result(property = "logo", column = "logo"),
            @Result(property = "rate", column = "rate"),
            @Result(property = "serviceCharge", column = "service_charge"),
            @Result(property = "topQota", column = "top_qota"),
            @Result(property = "bottomQota", column = "bottom_qota"),
            @Result(property = "outTime", column = "out_time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "orderNo", column = "order_no"),
            @Result(property = "enabled", column = "enabled")
    })
    @Select("select c.*, t.`module_id` from cooperation c inner join cooperation_type t on c.id = t.cooperation_id where t.module_id=#{moduleId} and enabled=1 limit #{start},#{end}")
    //@ResultType(Cooperation.class)
    List<Cooperation> selectByTypeAndPage(@Param("moduleId") String moduleId, @Param("start") int start, @Param("end") int end);
}