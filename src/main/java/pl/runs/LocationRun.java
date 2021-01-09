package pl.runs;

import pl.database.Entity.Location;

import java.io.IOException;

public class LocationRun implements Runnable{

    public LocationRun() throws IOException {
    }


    @Override
    public void run() {
        while(true) {
            Location location = new Location();

            System.out.println("Położenie stacji: ");
            System.out.println("Szerokość geograficzna: " + location.getLatitude());
            System.out.println("Długość geograficzna: " + location.getLongitude());
            System.out.println("Przybliżona prędkość stacji: " + location.getSpeed() + "km/h");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
