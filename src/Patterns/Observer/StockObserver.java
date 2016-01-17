package Patterns.Observer;

/**
 * Created by sebadmin on 2015-09-10.
 */
public class StockObserver implements Observer {

    double ibmPrice;
    double aaplPrice;
    double googPrice;

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;

        this.observerID = ++observerIDTracker;

        System.out.println("New Observer "+this.observerID);

        stockGrabber.register(this);
    }

    @Override
    public void update(double ibmPrice, double applPrice, double googPrice) {

        this.ibmPrice = ibmPrice;
        this.aaplPrice = applPrice;
        this.googPrice = googPrice;

        this.printThePrices();

    }

    public void printThePrices(){
        System.out.println(observerID+ "\nIBM: "+this.ibmPrice+
            "\nAAPL: "+this.aaplPrice+"\nGOOG: "+this.googPrice+"\n");
    }
}
