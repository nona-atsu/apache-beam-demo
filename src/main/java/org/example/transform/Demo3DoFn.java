package org.example.transform;

import org.apache.beam.sdk.transforms.DoFn;
import org.example.interfaces.SampleObj;

public class Demo3DoFn extends DoFn<SampleObj, Void> {

    @ProcessElement
    public void processElement(@Element SampleObj element) {
        System.out.println(element.getName());
    }
}
