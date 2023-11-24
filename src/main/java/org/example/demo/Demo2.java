package org.example.demo;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.example.transform.Demo2DoFn;

public class Demo2 {
    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.create();

        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> pCollection = pipeline.apply(Create.of("test1", "test2", "test3"));

        pCollection.apply("Demo1", ParDo.of(new Demo2DoFn()));

        pipeline.run();
    }
}