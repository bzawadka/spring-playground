package pl.bzawadka;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyResource {
    public final int id;
    public final String value;

    public MyResource(@JsonProperty("id") int id, @JsonProperty("value") String value) {
        this.id = id;
        this.value = value;
    }
}
