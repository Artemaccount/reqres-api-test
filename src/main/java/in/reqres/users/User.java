package in.reqres.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;
import java.util.stream.Stream;

@Data
public class User {
    private int id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String avatar;


    public boolean isAllFieldsNotNull() {
        return Stream.of(id, email, firstName, lastName, avatar)
                .allMatch(Objects::nonNull);
    }
}