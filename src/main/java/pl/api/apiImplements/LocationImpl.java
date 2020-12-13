package pl.api.apiImplements;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.api.apiInterfaces.LocationApi;
import pl.database.Entity.Location;

import java.io.IOException;


public class LocationImpl implements LocationApi {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";

    @Override
    public Location getLocation() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
        return null;
    }
}
