package pl.api.apiImplements;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.Location;
import pl.database.Entity.UpcomingRun;

import java.io.IOException;
import java.util.List;


public class UpcomingRunsImpl implements APIInterface {

    static Location location;

    static {
        try {
            location = new Location();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String longitude = String.valueOf(location.getLongitude());
    private static String latitude = String.valueOf(location.getLatitude());

    private static String BASE_URL = "http://api.open-notify.org/iss-pass.json?lat="+latitude+"&lon="+longitude;



    public UpcomingRunsImpl() throws IOException {
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    public String getJson() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();    OkHttpClient client = new OkHttpClient();
                Call call = client.newCall(request);
        Response response = call.execute();

        return response.body().string();
    }
}
