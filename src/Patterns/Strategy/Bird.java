package Patterns.Strategy;

/**
 * Created by sebadmin on 2015-09-10.
 */
public class Bird extends Animal {

    public Bird() {

        super();
        setSound("Tweet");

        flyingType = new ItFlys();
    }
}
