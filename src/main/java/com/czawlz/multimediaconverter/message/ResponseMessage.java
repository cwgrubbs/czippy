package com.czawlz.multimediaconverter.message;

import lombok.Data;
import lombok.NonNull;

@Data
public class ResponseMessage {

    @NonNull
    private String message;
}
