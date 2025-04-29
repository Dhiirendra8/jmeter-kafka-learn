package com.learn.jmeter.kafka.loadgenerator;

import co.signal.loadgen.SyntheticLoadGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

public class JsonLoadGenerator implements SyntheticLoadGenerator {

    private String key;
    private String value;

    public JsonLoadGenerator(String jsonValue){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String,Object> data =objectMapper.readValue(jsonValue, Map.class);
            this.key = data.get("id").toString();
            this.value = jsonValue;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
    public Pair<String, String> nextMessage() {
        return null;
    }
}
