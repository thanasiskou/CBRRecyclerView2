package com.cbr.android.cbrrecyclerview;

public class CbrObject {

    private String Name;
    private int Id;
    private boolean Working;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public CbrObject(String name,int id){
        this.Name = name;
        this.Id = id;
    }

    public CbrObject(String name,int id,boolean working){
        this.Name = name;
        this.Id = id;
        this.Working = working;
    }

    public boolean isWorking() {
        return Working;
    }

    public void setWorking(boolean working) {
        Working = working;
    }
}
