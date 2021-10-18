package com.company.Betab;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

final class Location implements Serializable {
    //Desc:This is going to be your location ID.
    private final int locationID;
    //Desc:This is going to be the description based on your location ID.
    private final String description;
    private final Map<String, Integer> exits;
    //Making this object serializable:
    private long serialVersionUID =1;

    public Location(int locationID, String description, Map<String, Integer> exit) {
        this.locationID = locationID;
        this.description = description;
        if(exit == null){
            this.exits = new LinkedHashMap<>();
        }
        else{
            this.exits =  new LinkedHashMap<>(exit);
        }
        this.exits.put("Q", 0);
    }
    //Getters for each private fields incorporating the knowledge of encapsulation.
    //Return: an int which is this.locationID.
    public int getLocationID() {
        return locationID;
    }
    //Return: a String which is the description of the location
    public String getDescription() {
        return description;
    }
    //Return: A hashmap which is a collection of the exits that are available for this.exits
    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits);
    }
    protected void addExit(String direction, int dest){
       this.exits.put(direction,dest);
    }

}
