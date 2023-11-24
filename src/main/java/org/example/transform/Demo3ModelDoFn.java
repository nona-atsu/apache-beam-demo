package org.example.transform;

import org.apache.beam.sdk.transforms.DoFn;
import org.example.interfaces.SampleObj;

public class Demo3ModelDoFn extends DoFn<String, SampleObj> {

    @ProcessElement
    public void processElement(@Element String element, OutputReceiver<SampleObj> out) {
        SampleObj model = new SampleObj();
        model.setName(element);
        out.output(model);
    }
}
