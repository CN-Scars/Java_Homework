package org.scars.FeedAnimals.Food;

public class Fish implements Food {
    private String name;

    public Fish(String name) {
        this.name = name;
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
