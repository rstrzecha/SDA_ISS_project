package pl.jsonToObject.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.api.JsonsSplit.UpcomingRunsSplit;
import pl.database.Entity.UpcomingPass;
import pl.jsonToObject.object.UpcomingRun;
import pl.jsonToObject.utils.TimestampToLocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class JsonToUpcomingPassMapper {

    private String json;

    public JsonToUpcomingPassMapper(String givenJson) {
        json = givenJson;
    }

    public List<UpcomingPass> getListofPasses() {
        UpcomingRunsSplit runsSplit = new UpcomingRunsSplit();
        String[] cutJson = runsSplit.splitJson(json);
        json = cutJson[0];
        List<UpcomingRun> upcomingRuns;
        ObjectMapper objectMapper = new ObjectMapper();

        List<UpcomingPass> upcomingPassList = new ArrayList<>();

        try {
            upcomingRuns = objectMapper.readValue(json, new TypeReference<>() {
            });

            for (UpcomingRun run: upcomingRuns) {
                UpcomingPass pass = new UpcomingPass();
                pass.setDuration(run.getDuration());
                pass.setRisetime(TimestampToLocalDateTime.getDateTime(run.getRisetime()));
                upcomingPassList.add(pass);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return upcomingPassList;
    }

}
