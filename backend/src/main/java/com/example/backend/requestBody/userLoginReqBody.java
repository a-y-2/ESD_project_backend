package com.example.backend.requestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class userLoginReqBody {

        @JsonProperty("email")
        private String email;

        @JsonProperty("password")
        private String password;
}
