package pl.runs;

import pl.api.apiImplements.LocationJson;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.IssLocation;

import java.io.IOException;

public class LocationRun implements Runnable{

    public LocationRun() throws IOException {
    }

    static IssLocation issLocation = null;
    APIInterface location = new LocationJson();

    @Override
    public void run() {

        while(true) {
            try {
                issLocation = new IssLocation(location.getJson());
            } catch (IOException e) {
                e.printStackTrace();
            }

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
