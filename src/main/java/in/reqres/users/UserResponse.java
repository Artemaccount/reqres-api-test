package in.reqres.users;

import lombok.Data;

@Data
public class UserResponse extends UserRequest{
    private int id;
    private String createdAt;
}
