package Patterns.Strategy;

/**
 * Created by sebadmin on 2015-09-10.
*/
public class Dog  extends Animal {

    public void digHole(){
        System.out.println("Dug a hole");
    }

    public Dog() {
        super();

        setSound("Bark");
        //sets the strategy pattern dynamically
        flyingType = new CantFly();
    }
}
