package top.fatbird.didadi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.fatbird.didadi.model.Proposal;

import java.util.List;

@Mapper
public interface ProposalsMapper {
    @Insert("insert into proposals (title,tag,description,expect_time,location,expect_number,recruited_number,creator,gmt_create,gmt_modified) values (#{title},#{tag},#{description},#{expectTime},#{location},#{expectNumber},#{recruitedNumber},#{creator},#{gmtCreate},#{gmtModified})")
    void create(Proposal proposal);
    @Select("select * from PROPOSALS")
    List<Proposal> list();
    @Select("select * from proposals where ID=#{id}")
    Proposal findById(@Param("id") Integer id);
}
