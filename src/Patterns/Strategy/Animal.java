package Patterns.Strategy;

/**
 * Created by sebadmin on 2015-09-10.
 */
public class Animal {

    String name;
    double height;
    int weight;
    String favFood;
    double speed;
    String sound;

    public Flys flyingType;

    public String tryToFly(){
        return flyingType.fly();
    }

    public void setFlyingType(Flys newFlyingType)
    {
        this.flyingType = newFlyingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
