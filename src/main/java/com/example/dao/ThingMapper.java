package com.example.dao;

import com.example.entity.Thing;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ThingMapper {

    @Select({"select * from supermarket"})
    List<Thing> getThing();

    @Delete({"delete from supermarket where thingcode=#{thingcode}"})
    void deleteThing(String thingcode);

    @Insert({"insert into supermarket(thingcode,thingname,personname,tel,fax,makedate) " +
            "values(#{thingcode},#{thingname},#{personname},#{tel},#{fax},#{makedate})"})
    void insertThing(Thing thing);

    @Update({"update supermarket set thingname=#{thingname},personname=#{personname}," +
            "tel=#{tel},fax=#{fax},makedate=#{makedate} where thingcode=#{thingcode}"})
    void updateThing(Thing thing);

    //通过thingcode查找他的所有数据
    @Select("select * from supermarket where thingcode=#{thingcode}")
    Thing editThing(String thingcode);

    //通过thingname查找他的所有数据,模糊查询
    @Select("select * from supermarket where thingname like CONCAT('%',#{thingname},'%')")
    List<Thing> selectThing(String thingname);
}
