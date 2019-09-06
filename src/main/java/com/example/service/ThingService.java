package com.example.service;

import com.example.entity.Thing;

import java.util.List;

public interface ThingService {

    List<Thing> getThing()throws Exception;

    void deleteThing(String thingcode)throws Exception;

    void insertThing(Thing thing)throws Exception;

    void updateThing(Thing thing)throws Exception;

    Thing editThing(String thingcode) throws Exception;

    List<Thing> selectThing(String thingname)throws Exception;
}
