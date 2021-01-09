package pl.api.apiImplements;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.IssLocation;

import java.io.IOException;


public class UpcomingRunsImpl implements APIInterface {

    static IssLocation issLocation;

    static {
            issLocation = new IssLocation();
    }

    private static String longitude = String.valueOf(issLocation.getLongitude());
    private static String latitude = String.valueOf(issLocation.getLatitude());

    private static String BASE_URL = "http://api.open-notify.org/iss-pass.json?lat="+latitude+"&lon="+longitude;

    public static String getBaseUrl() {
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
