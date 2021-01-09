package pl.api.apiImplements;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.api.apiInterfaces.AstronautApi;
import pl.database.Entity.Astronaut;

import java.io.IOException;
import java.util.List;

public class AstronautImpl implements AstronautApi {
    private final static String BASE_URL = "http://api.open-notify.org/astros.json";

    @Override
    public List<Astronaut> getAstronauts()throws IOException { return null;}

    public static void main (String[] args) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
}
