package Patterns.Strategy;

/**
 * Created by sebadmin on 2015-09-10.
 */
public interface Flys {

    String fly();
}

class ItFlys implements Flys {

    @Override
    public String fly() {
        return "Flying High";
    }
}

class CantFly implements Flys {

    @Override
    public String fly() {
        return "Cant Fly";
    }
}