package Patterns.Observer;

import java.text.DecimalFormat;

/**
 * Created by sebadmin on 2015-09-10.
 * testing threads
 */
public class GetTheStock implements Runnable{

    int startTime;
    String stock;
    double price;

    Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int startTime, String stock, double price) {
        this.stockGrabber = stockGrabber;
        this.price = price;
        this.stock = stock;
        this.startTime = startTime;
    }

    @Override
    public void run() {

        System.out.println("Starting thread");

        for (int i = 1; i < 20; i++) {

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {

            }

            double randNum = (Math.random() * (.06)) - .03;
            //Problem med svenska tecken uppsettning iom vi anvander , istallet for .
            DecimalFormat df = new DecimalFormat("#.##");

            String swePrice = df.format((price + randNum));
            swePrice = swePrice.replace(',','.');

            price = Double.valueOf(swePrice);

            switch (stock)
            {
                case "IBM":
                    ((StockGrabber) stockGrabber).setIbmPrice(price);
                    break;
                case "AAPL":
                    ((StockGrabber) stockGrabber).setIbmPrice(price);
                    break;
                case "GOOG":
                    ((StockGrabber) stockGrabber).setIbmPrice(price);
                    break;
            }

            System.out.println(stock +": "+df.format((price+randNum))+" "+df.format(randNum));

            System.out.println();

        }
    }
}
