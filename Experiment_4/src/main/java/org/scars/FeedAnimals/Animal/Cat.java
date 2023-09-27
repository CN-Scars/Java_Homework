package org.scars.FeedAnimals.Animal;

import org.scars.FeedAnimals.Food.Bone;
import org.scars.FeedAnimals.Food.Food;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        System.out.println("饲养员给小猫喂" + food.getName() + "，");
    }

    @Override
    public void shout() {
        System.out.println("小猫喵喵叫。");
    }
}
