package model;

import exceptions.WrongWeightException;

public class Ingredient {

    private String name;
    private int weight = 0;

    public Ingredient(){

    }

    public void addWeight(int weightAdded) throws Exception{
        if(weightAdded < 0) throw new WrongWeightException();
        else this.weight += weightAdded;
    }

    public void removeWeight(int weightRemoved) throws Exception{
        if(weightRemoved < 0) throw new WrongWeightException();
        else this.weight -= weightRemoved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws Exception{
        if(weight < 0) throw new WrongWeightException();
        else this.weight = weight;
    }
    
}
