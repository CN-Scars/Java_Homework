package org.scars.FeedAnimals.Animal;

import org.scars.FeedAnimals.Food.Bone;
import org.scars.FeedAnimals.Food.Food;

public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat(Food food) {
        System.out.println("饲养员给小狗喂" + food.getName() + "，");
    }

    @Override
    public void shout() {
        System.out.println("小狗汪汪叫。");
    }
}
