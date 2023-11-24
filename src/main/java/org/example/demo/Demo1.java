package org.example.demo;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.example.transform.Demo1DoFn;

public class Demo1 {
    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.create();

        Pipeline pipeline = Pipeline.create(options);

        PCollection<Integer> pCollection = pipeline.apply(Create.of(111, 222, 333));

        pCollection.apply("Demo1", ParDo.of(new Demo1DoFn()));

        pipeline.run();
    }
}