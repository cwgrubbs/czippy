package com.czawlz.czippy.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class FileInfo {

    @NonNull
    private String name;
    @NonNull
    private String url;
}
