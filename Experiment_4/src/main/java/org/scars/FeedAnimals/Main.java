package org.scars.FeedAnimals;

import org.scars.FeedAnimals.Animal.Cat;
import org.scars.FeedAnimals.Animal.Dog;
import org.scars.FeedAnimals.Food.Bone;
import org.scars.FeedAnimals.Food.Fish;
import org.scars.FeedAnimals.Food.Food;

public class Main {
    public static void main(String[] args) {
        Feeder feeder = new Feeder("小华");
        feeder.speak();
        Dog dog = new Dog("小狗");
        dog.shout();
        Food food = new Bone();
        feeder.feed(dog, food);
        Cat cat = new Cat("小猫");
        cat.shout();
        food = new Fish("黄花鱼");
        feeder.feed(cat, food);
    }
}
