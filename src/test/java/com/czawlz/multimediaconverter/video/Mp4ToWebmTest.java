package com.czawlz.multimediaconverter.video;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Mp4ToWebmTest {

    @Test
    void testConvertMp4ToWebm() throws IOException {
        Mp4ToWebm mp4ToWebm = new Mp4ToWebm();
        mp4ToWebm.convert();
    }

}
