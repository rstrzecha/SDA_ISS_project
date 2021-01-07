package pl.api.JsonsSplit;

import pl.api.apiImplements.AstronautImpl;
import pl.api.apiInterface.APIInterface;
import pl.api.apiInterface.SplitJsonInterface;

import java.io.IOException;

public class AstronautSplit implements SplitJsonInterface {


    public AstronautSplit() throws IOException {
    }

    APIInterface astronaut = new AstronautImpl();
    private String json = astronaut.getJson();

    @Override
    public String[] splitJson() {
        return new String[0];
    }
}
