package org.example.interfaces;

import lombok.Data;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.extensions.avro.coders.AvroCoder;

@Data
@DefaultCoder(AvroCoder.class)
public class SampleObj4 {
    private String name;
}
