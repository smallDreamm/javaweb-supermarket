package com.example.controller;

import com.example.entity.Thing;
import com.example.service.ThingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/thing")
public class ThingController {
    @Autowired
    private ThingService ThingService;

    //查看商品列表
    @RequestMapping(value="/thinglist")
    public ModelAndView getThing()throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Thing> list=ThingService.getThing();
        mv.addObject("list",list);
        mv.setViewName("thinglist");
        return mv;
    }
    //删除商品
    @RequestMapping(value="/thingdelete/{thingcode}")
    public ModelAndView deleteThing(@PathVariable("thingcode") String thingcode) throws Exception{
        ThingService.deleteThing(thingcode);
        return getThing();
    }

    //跳转添加页面
    @RequestMapping(value = "insertPage")
    public String insertPage(){
        return "addthing";
    }

    //添加商品
    @RequestMapping(value="/thingadd")
    public ModelAndView insertThing(Thing thing)throws Exception{
        ThingService.insertThing(thing);
        return getThing();
    }

    //在updatething页面上通过thingcode获取数据
    @RequestMapping(value = "/thingedit/{thingcode}")
    public ModelAndView editThing(@PathVariable("thingcode")String thingcode) throws Exception{
        ModelAndView modelAndView = new ModelAndView("updatething");
        Thing thing = ThingService.editThing(thingcode);
        modelAndView.addObject("thing", thing);
        return modelAndView;
    }

    //修改商品
    @RequestMapping(value = "/thingupdate")
    public ModelAndView updateThing(Thing thing)throws Exception{
        ThingService.updateThing(thing);
        return getThing();
    }

    //通过thingname查找商品
    @RequestMapping(value = "/thingselect")
    public ModelAndView selectThing(String thingname) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Thing> list =ThingService.selectThing(thingname);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("thinglist");
        return modelAndView;
    }
    //分页
    @RequestMapping(value = "helper")
    @ResponseBody
    public PageInfo<Thing> Helper(Integer pageNum,Integer pageSize ){
        PageInfo pageInfo = ThingService.selectThing(pageNum,pageSize);
        return pageInfo;
    }



    //日期转换
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



}
