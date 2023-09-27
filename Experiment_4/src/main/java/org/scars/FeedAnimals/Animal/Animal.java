package org.scars.FeedAnimals.Animal;

import org.scars.FeedAnimals.Food.Food;

public abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public void eat(Food food){}

    public void shout(){}
}
