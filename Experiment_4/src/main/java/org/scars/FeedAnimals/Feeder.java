package org.scars.FeedAnimals;

import org.scars.FeedAnimals.Animal.Animal;
import org.scars.FeedAnimals.Food.Food;

public class Feeder {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Feeder(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("欢迎来到动物园！");
        System.out.println("我是饲养员  "+ name);
    }

    void feed(Animal animal, Food food) {
        animal.eat(food);
    }
}
