package org.example.demo;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.example.interfaces.SampleObj;
import org.example.transform.Demo3DoFn;
import org.example.transform.Demo3ModelDoFn;

public class Demo3 {
    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.create();

        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> stringPCollection = pipeline.apply(Create.of("aaa", "bbb", "ccc"));

        PCollection<SampleObj> pCollection = stringPCollection.apply(ParDo.of(new Demo3ModelDoFn()));

        pCollection.apply("Demo3", ParDo.of(new Demo3DoFn()));

        pipeline.run();
    }
}