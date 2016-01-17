package Patterns.Observer;

/**
 * Created by sebadmin on 2015-09-10.
 */
public class MainGrabStocks {

    public static void main(String[] args) {

        StockGrabber stockGrabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(stockGrabber);


        stockGrabber.setIbmPrice(197.0);
        stockGrabber.setAaplPrice(333.0);
        stockGrabber.setGoogPrice(676.0);

        StockObserver observer2 = new StockObserver(stockGrabber);

        stockGrabber.setGoogPrice(276.0);
        stockGrabber.unregister(observer1);

        Runnable getIBM = new GetTheStock(stockGrabber,2,"IBM", 197.00);
        Runnable getAAPL = new GetTheStock(stockGrabber,2,"AAPL", 677.00);
        Runnable getGOOG= new GetTheStock(stockGrabber,2,"GOOG", 676.00);

        new Thread(getIBM).start();
        new Thread(getAAPL).start();
        new Thread(getGOOG).start();


    }
}
