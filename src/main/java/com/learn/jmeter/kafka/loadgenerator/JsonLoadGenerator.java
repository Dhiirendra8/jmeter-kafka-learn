package com.learn.jmeter.kafka.loadgenerator;

import co.signal.loadgen.LoadGenerator;
import co.signal.loadgen.SyntheticLoadGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class JsonLoadGenerator implements SyntheticLoadGenerator {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String key;
    private String value;

    private Map<String,String> map = new HashMap<>();

    public JsonLoadGenerator(String jsonValue){
        System.out.println("Value from File: "+jsonValue);
        try {
            var data = (Map<String,Object>) objectMapper.readValue(jsonValue, Map.class);
            this.key = data.get("key").toString();
            this.value = data.get("value").toString();;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
    public Pair<String, String> nextMessage() {
        return Pair.of(this.key,this.value);
    }
}
