package com.czawlz.czippy.message;

import lombok.Data;
import lombok.NonNull;

@Data
public class ResponseMessage {

    @NonNull
    private String message;
}
