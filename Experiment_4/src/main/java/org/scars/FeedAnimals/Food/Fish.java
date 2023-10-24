package org.scars.FeedAnimals.Food;

import org.scars.FeedAnimals.Animal.Animal;

public class Fish extends Animal implements Food {
    public Fish(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "鱼";
    }

    public void eat(Food food) {
        if (food instanceof Fish) {
            System.out.println("鱼正在吃猫");
        }
    }
}
