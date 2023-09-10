package com.example.tx.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "success",
        "score",
        "action",
        "challenge_ts",
        "hostname",
        "error-codes"
})
@Getter
@Setter
public class GoogleResponse {

    @JsonProperty("success")
    private boolean success;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("error-codes")
    private ErrorCode[] errorCodes;
    @JsonProperty("score")
    private float score;
    @JsonProperty("action")
    private String action;

    @JsonIgnore
    public boolean hasClientError() {
        ErrorCode[] errors = getErrorCodes();
        if(errors == null) {
            return false;
        }
        for(ErrorCode error : errors) {
            switch(error) {
                case InvalidResponse:
                case MissingResponse:
                case InvalidKeys:
                    return true;
            }
        }
        return false;
    }

    static enum ErrorCode {
        MissingSecret,     InvalidSecret,
        MissingResponse,   InvalidResponse, InvalidKeys;

        private static Map<String, ErrorCode> errorsMap = new HashMap<>(4);

        static {
            errorsMap.put("missing-input-secret",   MissingSecret);
            errorsMap.put("invalid-input-secret",   InvalidSecret);
            errorsMap.put("missing-input-response", MissingResponse);
            errorsMap.put("invalid-input-response", InvalidResponse);
            errorsMap.put("invalid-keys", InvalidKeys);
        }

        @JsonCreator
        public static ErrorCode forValue(String value) {
            return errorsMap.get(value.toLowerCase());
        }
    }


}
