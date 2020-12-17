package pl.api.apiImplements;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.UpcomingRun;

import java.io.IOException;
import java.util.List;


public class UpcomingRunsImpl implements APIInterface {

    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";
    @Override
    public String getJson() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();    OkHttpClient client = new OkHttpClient();    Call call = client.newCall(request);
        Response response = call.execute();

        return response.body().string();
    }
}
