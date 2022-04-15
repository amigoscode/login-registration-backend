package com.example.demo.registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    //We have to remove the final from here to set the values
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;


    //We have to use this now a days, if not we are going to face the
    // [com-fasterxml-jackson-databind-exc-invaliddefinitionexception-cannot-construct-instance-of-xyz-no-creators-
    // like-default-construct-exist-cannot-deserialize-from-object-value-no-delega/]
    //I faced the error recently.
    //I have used the statergy of default constructor.

    public RegistrationRequest() {
    }

    public RegistrationRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
