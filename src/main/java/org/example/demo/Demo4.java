package org.example.demo;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.example.interfaces.SampleObj4;
import org.example.transform.Demo4DoFn;

public class Demo4 {
    public static void main(String[] args) {
        // Start by defining the options for the pipeline.
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).create();

        // Then create the pipeline.
        Pipeline p = Pipeline.create(options);

        // Create the PCollection 'lines' by applying a 'Read' transform
        PCollection<String> pCollection = p.apply("Read", TextIO.read().from("src/main/resources/input.txt"));

        //output
        PCollection<SampleObj4> output = pCollection.apply(ParDo.of(new Demo4DoFn()));

        output.apply(ParDo.of(
                new DoFn<SampleObj4, Void>() {
                    @ProcessElement
                    public void processElement(@Element SampleObj4 element) {
                        System.out.println(element);
                    }
                }
        ));

        // Run the pipeline.
        p.run();
    }
}
