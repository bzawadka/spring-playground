package pl.bzawadka;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyResource {
    public final int id;
    public final String value;

    /**
     * Jackson deserialization with immutable object without stupid annotations:
     * http://stackoverflow.com/questions/4822856/does-jackson-without-annotations-absolutely-require-setters
     */
    public MyResource(@JsonProperty("id") int id, @JsonProperty("value") String value) {
        this.id = id;
        this.value = value;
    }
}
