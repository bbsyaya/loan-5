package com.loan.datasource.mappers;

import com.loan.datasource.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    /**
     * 获取用户列表
     * @return
     */
    /**
     * 根据id获取具体内容
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "loginName", column = "login_name"),
            @Result(property = "regTime", column = "reg_time"),
            @Result(property = "petName", column = "pet_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "email", column = "email"),
            @Result(property = "lastLoginTime", column = "last_login_time")
    })
    @Select("select id,login_name,reg_time,pet_name,mobile,email,last_login_time from user order by reg_time desc limit #{limit}, #{page}")
    List<User> getUserListByPage(@Param("limit") long limit, @Param("page") int page);

    /**
     * 获取用户列表
     * @return
     */
    /**
     * 根据id获取具体内容
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "loginName", column = "login_name"),
            @Result(property = "regTime", column = "reg_time"),
            @Result(property = "petName", column = "pet_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "email", column = "email"),
            @Result(property = "lastLoginTime", column = "last_login_time")
    })
    @Select("<script>select id,login_name,reg_time,pet_name,mobile,email,last_login_time from user " +
            "where 1=1 <when test='mobile!=null'>" +
            " AND mobile = #{mobile} </when>" +
            " <when test='login_name!=null'>" +
            " AND login_name = #{user.loginName} </when>" +
            "order by reg_time desc limit #{limit}, #{page}</script>")
    List<User> getUserListByPageAndCondition(@Param("user") User user, @Param("limit") long limit, @Param("page") int page);

    /**
     * 根据Id获取用户信息
     * @return
     */
    /**
     * 根据id获取具体内容
     * @param id
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "loginName", column = "login_name"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "idCard", column = "id_card"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "qq", column = "qq"),
            @Result(property = "wechart", column = "wechart"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "education", column = "education"),
            @Result(property = "job", column = "job"),
            @Result(property = "regTime", column = "reg_time"),
            @Result(property = "lastLoginTime", column = "last_login_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    @Select("select * from user where id= #{id} and enabled")
    User getUserById(@Param("id") long id);

    /**
     * 根据Id获取用户信息
     * @return
     */
    /**
     * 根据id获取具体内容
     * @param loginName 登录名称
     * @param pwd 登录密码
     * @return
     */
    @ResultType(Integer.class)
    @Select("select count(*) from user where login_name = #{loginName} and password = #{pwd}")
    Integer login(@Param("loginName") String loginName, @Param("pwd") String pwd);

    /**
     * 插入用户
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into user values (null,#{user.loginName},#{user.password},#{user.regTime},#{user.petName},#{user.mobile},#{user.email},#{user.lastLoginTime}, 1)")
    @Options(useGeneratedKeys=true,keyProperty="user.id")
    int insertUser(@Param("user") User user) throws Exception;

}