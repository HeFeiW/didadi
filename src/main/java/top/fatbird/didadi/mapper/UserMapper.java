package top.fatbird.didadi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.fatbird.didadi.model.User;

@Mapper
public interface UserMapper {
    @Insert("insert into users (name,accountid,token,gmtcreate,gmtmodified,encryptpwd) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{password})")
    void insert(User user);
    @Select("select * from users where token=#{token}")
    User findByToken(@Param("token") String token);
}
