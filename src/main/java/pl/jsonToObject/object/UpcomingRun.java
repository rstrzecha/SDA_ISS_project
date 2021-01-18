package pl.jsonToObject.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpcomingRun {

    public UpcomingRun() {
    }

    @JsonProperty
    private int duration;

    @JsonProperty
    private long risetime;

    public int getDuration() {
        return duration;
    }

    public long getRisetime() {
        return risetime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRisetime(long risetime) {
        this.risetime = risetime;
    }

    @Override
    public String toString() {
        return "UpcomingRun{" +
                "duration=" + duration +
                ", risetime=" + risetime +
                '}';
    }
}
