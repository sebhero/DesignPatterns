package Patterns.Observer;

/**
 * Created by sebadmin on 2015-09-10.
 */
public interface Subject {

    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();


}
