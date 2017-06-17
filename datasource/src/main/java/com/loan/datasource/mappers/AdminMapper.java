package com.loan.datasource.mappers;

import com.loan.datasource.entities.Admin;
import com.loan.datasource.entities.AdminExample;
import com.loan.datasource.params.AdminParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 根据Id获取用户信息
     * @return
     */
    /**
     * 根据id获取具体内容
     * @return
     */
    @Select("<script>select * from admin " +
            "where 1=1 <when test='admin.loginName!=null'>" +
            " AND login_name = #{admin.loginName} </when>" +
            " <when test='admin.trueName!=null'>" +
            " AND login_name = #{admin.trueName} </when>" +
            "order by create_time desc limit #{skip}, #{page}</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "loginName", column = "login_name"),
            @Result(property = "loginPwd", column = "login_pwd"),
            @Result(property = "trueName", column = "true_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "enabled", column = "enabled")
    })
    public List<Admin> findAdminListByPage(@Param("admin") AdminParam admin, @Param("skip") int skip, @Param("page") int page);

    /**
     * 通过id获取admin信息
     * @param id
     * @return
     */
    @Select("select * from admin where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "loginName", column = "login_name"),
            @Result(property = "loginPwd", column = "login_pwd"),
            @Result(property = "trueName", column = "true_name"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "enabled", column = "enabled")
    })
    public Admin getAdminById(@Param("id") Long id);

    /**
     * 登录
     * @return
     */
    /**
     * 根据id获取具体内容
     * @return
     */
    @Select("select count(*) from admin where login_name = #{loginName} and login_pwd = #{pwd}")
    @ResultType(Integer.class)
    public int login(@Param("loginName") String loginName, @Param("pwd") String pwd);

    /**
     * 更新，修改
     * @return
     */
    /**
     * 根据id获取具体内容
     * @return
     */
    @Select("update admin set true_name=#{admin.trueName}, mobile=#{admin.mobile}, enabled=#{admin.enabled}, update_time=#{admin.updateTime} where id=#{admin.id}")
    public void updateAdmin(@Param("admin") Admin admin);

    /**
     * 插入用户
     * @param admin
     * @return
     * @throws Exception
     */
    @Insert("insert into admin (id, login_name, login_pwd, true_name, mobile, enabled) values (null, #{admin.loginName},#{admin.loginPwd},#{admin.trueName},#{admin.mobile},1)")
    @Options(useGeneratedKeys=true, keyProperty="admin.id")
    int insertAdmin(@Param("admin") Admin admin) throws Exception;

    /**
     * 获取用户总数
     * @return
     * @throws Exception
     */
    @Select("select count(*) from admin")
    //@ResultType(Integer.class)
    int adminCount();
}