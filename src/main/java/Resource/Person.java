package Resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
    @JsonProperty("address")
    private String address;
}
