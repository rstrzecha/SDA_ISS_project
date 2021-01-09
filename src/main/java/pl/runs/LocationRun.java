package pl.runs;

import pl.database.Entity.IssLocation;

import java.io.IOException;

public class LocationRun implements Runnable{

    public LocationRun() throws IOException {
    }


    @Override
    public void run() {
        while(true) {
            IssLocation issLocation = new IssLocation();

            System.out.println("Położenie stacji: ");
            System.out.println("Szerokość geograficzna: " + issLocation.getLatitude());
            System.out.println("Długość geograficzna: " + issLocation.getLongitude());
            System.out.println("Przybliżona prędkość stacji: " + issLocation.getSpeed() + "km/h");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
