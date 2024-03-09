package top.fatbird.didadi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.fatbird.didadi.model.User;

@Mapper
public interface UserMapper {
    @Insert("insert into users (name,account_id,token,gmt_create,gmt_modified,password,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{password},#{avatarUrl})")
    void insert(User user);
    @Select("select * from users where token=#{token}")
    User findByToken(@Param("token") String token);
    @Select("select * from users where ID=#{id}")
    User findById(@Param("id") Integer creator);
    @Select("select * from users where ACCOUNT_ID=#{account_id}")
    User findByAccountId(@Param("account_id") String userId);
}
