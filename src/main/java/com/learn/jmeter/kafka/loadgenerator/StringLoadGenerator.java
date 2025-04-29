package com.learn.jmeter.kafka.loadgenerator;

import co.signal.loadgen.SyntheticLoadGenerator;
import org.apache.commons.lang3.tuple.Pair;

import java.util.UUID;

public class StringLoadGenerator implements SyntheticLoadGenerator {
    private String key;
    private String value;

    public StringLoadGenerator(String value){
        System.out.println("Value from File: "+value);
        this.value = value;
        this.key = UUID.randomUUID().toString();
    }
    @Override
    public Pair<String, String> nextMessage() {
        return Pair.of(this.key, this.value);
    }
}
