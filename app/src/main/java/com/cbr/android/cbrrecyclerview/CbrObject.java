package com.cbr.android.cbrrecyclerview;

public class CbrObject{

    private String name;
    private int id;
    private boolean isWorking;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CbrObject(String name,int id){
        this.name = name;
        this.id = id;
    }

    public CbrObject(String name,int id,boolean isWorking){
        this.name = name;
        this.id = id;
        this.isWorking = isWorking;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
