package com.loan.datasource.mappers;

import com.loan.datasource.entities.Cooperation;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CooperationMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "appName", column = "app_name"),
            @Result(property = "logo", column = "logo"),
            @Result(property = "rate", column = "rate"),
            @Result(property = "serviceCharge", column = "service_charge"),
            @Result(property = "topQota", column = "top_qota"),
            @Result(property = "bottomQota", column = "bottom_qota"),
            @Result(property = "outTime", column = "out_time"),
            @Result(property = "loanTime", column = "loan_time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "orderNo", column = "order_no"),
            @Result(property = "enabled", column = "enabled")
    })
    @Select("select c.*, t.`module_id` from cooperation c inner join cooperation_type t on c.id = t.cooperation_id where t.module_id=#{moduleId} and enabled=1 limit #{start},#{end}")
        //@ResultType(Cooperation.class)
    List<Cooperation> selectByTypeAndPage(@Param("moduleId") String moduleId, @Param("start") int start, @Param("end") int end);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "appName", column = "app_name"),
            @Result(property = "logo", column = "logo"),
            @Result(property = "rate", column = "rate"),
            @Result(property = "serviceCharge", column = "service_charge"),
            @Result(property = "topQota", column = "top_qota"),
            @Result(property = "bottomQota", column = "bottom_qota"),
            @Result(property = "outTime", column = "out_time"),
            @Result(property = "loanTime", column = "loan_time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "orderNo", column = "order_no"),
            @Result(property = "enabled", column = "enabled")
    })
    @Select("select * from cooperation  where enabled=1 limit #{start},#{end}")
        //@ResultType(Cooperation.class)
    List<Cooperation> selectByPage(@Param("start") int start, @Param("end") int end);

    /**
     * 根据id获取具体内容
     *
     * @return
     */
    @Select("select count(*) from cooperation")
    @ResultType(Integer.class)
    public int login(@Param("loginName") String loginName, @Param("pwd") String pwd);

    /**
     * 更新，修改
     * @return
     */
    /**
     * 根据id获取具体内容
     *
     * @return
     */
    @Select("update cooperation set app_name=#{cooperation.appName}, logo=#{cooperation.logo}, rate=#{cooperation.rate}, service_charge=#{cooperation.serviceCharge}, top_qota=#{cooperation.topQota}, bottom_qota=#{cooperation.bottomQota}, out_time=#{cooperation.outTime}, loan_time=#{cooperation.loanTime} out_time=#{cooperation.updateTime}, order_no=#{cooperation.orderNo}, enabled=#{cooperation.enabled}  where id=#{cooperation.id}")
    public void update(@Param("cooperation") Cooperation cooperation);

    /**
     * 插入用户
     *
     * @param cooperation
     * @return
     * @throws Exception
     */
    @Insert("insert into cooperation values (null, #{cooperation.appName},#{cooperation.logo},#{cooperation.rate},#{cooperation.serviceCharge},#{cooperation.topQota},#{cooperation.bottomQota},#{cooperation.outTime}, #{cooperation.createTime}, #{cooperation.loanTime},#{cooperation.updateTime},#{cooperation.orderNo},1)")
    @Options(useGeneratedKeys = true, keyProperty = "cooperation.id")
    int insert(@Param("cooperation") Cooperation cooperation) throws Exception;

    /**
     * 更新，修改
     * @return
     */
    /**
     * 根据id获取具体内容
     *
     * @return
     */
    @Select("select * from cooperation where id =#{id}")
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
            @Result(property = "loanTime", column = "loan_time"),
            @Result(property = "orderNo", column = "order_no"),
            @Result(property = "enabled", column = "enabled")
    })
    public Cooperation findById(@Param("id") long id);

    /**
     * 获取用户总数
     * @return
     * @throws Exception
     */
    @Select("<script>select count(*) from cooperation c inner join cooperation_type t on c.`id` = t.`cooperation_id`" +
            " where 1=1 <when test='type!=0'>" +
            " AND t.`module_id` = #{type} </when>" +
            " order by create_time desc</script>")
    int cooperationCount(@Param("type") int type);
}