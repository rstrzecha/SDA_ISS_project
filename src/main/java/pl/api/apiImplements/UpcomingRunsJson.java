package pl.api.apiImplements;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.IssLocation;
import pl.database.Entity.UserLocation;
import pl.runs.LocationRun;

import java.io.IOException;


public class UpcomingRunsJson implements APIInterface {

//    private static IssLocation issLocation = null; //Trzeba pobrać z bazy danych ostatnią lokalizację ISS

//    private static String longitude = String.valueOf(issLocation.getLongitude());
//    private static String latitude = String.valueOf(issLocation.getLatitude());

//    private String longitude;
//    private String latitude;


//    private static String BASE_URL = "http://api.open-notify.org/iss-pass.json?lat="+latitude+"&lon="+longitude;
    private String BASE_URL;


    public UpcomingRunsJson() throws IOException {
    }

    public UpcomingRunsJson(UserLocation givenLocation) throws IOException {
        BASE_URL = "http://api.open-notify.org/iss-pass.json?lat="
                +(givenLocation.getLongitude())
                +"&lon="+(givenLocation.getLatitude());
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    @Override
    public String getJson() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
                OkHttpClient client = new OkHttpClient();
                Call call = client.newCall(request);
        Response response = call.execute();

        return response.body().string();
    }
}
