package Patterns.Observer;

import java.util.ArrayList;

/**
 * Created by sebadmin on 2015-09-10.
 */
public class StockGrabber implements Subject{


    ArrayList<Observer> observers;
    double ibmPrice;
    double aaplPrice;
    double googPrice;

    public StockGrabber() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);

    }

    @Override
    public void unregister(Observer deleteObserver) {

        int obsIndx = observers.indexOf(deleteObserver);

        System.out.println("Observer deleted "+obsIndx);

        this.observers.remove(deleteObserver);

    }

    @Override
    public void notifyObserver() {

        for(Observer observer : this.observers)
        {
            observer.update(ibmPrice,aaplPrice,googPrice);
        }
    }

    public void setIbmPrice(double newIbmPrice)
    {
        this.ibmPrice = newIbmPrice;
        notifyObserver();
    }
    public void setAaplPrice(double newAaplPrice)
    {
        this.aaplPrice = newAaplPrice;
        notifyObserver();
    }
    public void setGoogPrice(double newGoogPrice)
    {
        this.googPrice = newGoogPrice;
        notifyObserver();
    }

}
