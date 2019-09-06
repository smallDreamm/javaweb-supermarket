package com.example.service;

import com.example.dao.ThingMapper;
import com.example.entity.Thing;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ThingServiceImpl implements ThingService {
    @Resource
    private ThingMapper ThingMapper;

    @Override
    public List<Thing> getThing()throws Exception{
        return ThingMapper.getThing();
    }

    @Override
    public void deleteThing(String thingcode)throws Exception{
        ThingMapper.deleteThing(thingcode);
    }

    @Override
    public void insertThing(Thing thing)throws Exception{
        ThingMapper.insertThing(thing);
    }

    @Override
    public void updateThing(Thing thing)throws Exception{
        ThingMapper.updateThing(thing);
    }

    @Override
    public Thing editThing(String thingcode) throws Exception {
        return ThingMapper.editThing(thingcode);
    }

    @Override
    public List<Thing> selectThing(String thingname)throws Exception{
        return ThingMapper.selectThing(thingname);
    }

    //    分页
    public PageInfo selectList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize); // 设定当前页码，以及当前页显示的条数
        //PageHelper.offsetPage(pageNum, pageSize);也可以使用此方式进行设置
        List<Thing> list = ThingMapper.selectThing(thingname);
        PageInfo<Thing> pageInfo = new PageInfo<Thing>(list);
        return pageInfo;
    }
}
