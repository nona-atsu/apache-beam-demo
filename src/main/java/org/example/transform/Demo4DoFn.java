package org.example.transform;

import org.apache.beam.sdk.transforms.DoFn;
import org.example.interfaces.SampleObj4;

public class Demo4DoFn extends DoFn<String, SampleObj4> {

    @ProcessElement
    public void processElement(@Element String element, OutputReceiver<SampleObj4> out) {
        SampleObj4 model = new SampleObj4();
        model.setName(element);
        out.output(model);
    }
}
