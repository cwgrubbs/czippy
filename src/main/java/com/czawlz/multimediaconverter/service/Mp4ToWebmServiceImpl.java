package com.czawlz.multimediaconverter.service;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFmpegUtils;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class Mp4ToWebmServiceImpl implements Mp4ToWebmService {

    public void convert() throws IOException {

        FFmpeg ffmpeg = new FFmpeg();
        FFprobe ffprobe = new FFprobe();
        FFmpegProbeResult in = ffprobe.probe("/home/czawlz/Videos/dd.mp4");

        FFmpegBuilder builder = new FFmpegBuilder()

                .setInput(in)     // Filename, or a FFmpegProbeResult
                .overrideOutputFiles(true) // Override the output if it exists

                .addOutput("/home/czawlz/Videos/dd.webm")   // Filename for the destination
                .setFormat("webm")        // Format is inferred from filename, or can be set
                //.setTargetSize(250_000)  // Aim for a 250KB file

                .disableSubtitle()       // No subtiles

                .setAudioChannels(2)         // stereo audio
                .setAudioCodec("vorbis")        // using the ogg vorbis codec
                .setAudioSampleRate(48_000)  // at 48KHz
                .setAudioBitRate(32768)      // at 32 kbit/s

                //.setVideoCodec("av1")     // Video using AV1
                //.setVideoFrameRate(24, 1)     // at 24 frames per second
                //.setVideoResolution(640, 480) // at 640x480 resolution

                .setPreset("ultrafast")

                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL).done(); // Allow FFmpeg to use experimental specs

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);

        // Run a one-pass encode
        executor.createJob(builder, new ProgressListener() {

            // Using the FFmpegProbeResult determine the duration of the input
            final double duration_ns = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(Progress progress) {
                double percentage = progress.out_time_ns / duration_ns;

                // Print out interesting information about the progress
                System.out.printf(
                        "[%.0f%%] status:%s frame:%d time:%s ms fps:%.0f speed:%.2fx%n",
                        percentage * 100,
                        progress.status,
                        progress.frame,
                        FFmpegUtils.toTimecode(progress.out_time_ns, TimeUnit.NANOSECONDS),
                        progress.fps.doubleValue(),
                        progress.speed
                );
            }
        }).run();
    }

}
