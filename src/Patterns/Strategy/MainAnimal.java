package Patterns.Strategy;

/**
 * Created by sebadmin on 2015-09-10.
 */
public class MainAnimal {

    public static void main(String[] args) {
        Animal sparky  = new Dog();
        Animal birdy = new Bird();

        System.out.println("Dog "+sparky.tryToFly());
        System.out.println("Bird " + birdy.tryToFly());

        //change dynamically change dogs ability
        sparky.setFlyingType(new ItFlys());

        System.out.println("Dog "+sparky.tryToFly());

    }

}
