package org.example.transform;

import org.apache.beam.sdk.transforms.DoFn;

public class Demo1DoFn extends DoFn<Integer, Void> {

    @ProcessElement
    public void processElement(@Element Integer element) {
        System.out.println("Demo1DoFn.processElement: " + element);
    }
}
