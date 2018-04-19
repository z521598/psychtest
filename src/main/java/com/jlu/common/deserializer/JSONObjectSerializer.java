package com.jlu.common.deserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

/**
 * Created by baidu on 15/11/18.
 */
public class JSONObjectSerializer extends JsonSerializer<JSONObject> {

    @Override
    public void serialize(JSONObject value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeTree(new ObjectMapper().readTree(value.toString()));

    }
}
