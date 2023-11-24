package org.example.transform;

import org.apache.beam.sdk.transforms.DoFn;

public class Demo2DoFn extends DoFn<String, Void> {

    @ProcessElement
    public void processElement(@Element String element) {
        System.out.println("Demo1DoFn.processElement: " + element);
    }
}
