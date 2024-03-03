package top.fatbird.didadi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.fatbird.didadi.model.User;

@Mapper
public interface UserMapper {
    @Insert("insert into users (account_name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * users where token=#{token}")
    User findByToken(@Param("token") String token);
}
