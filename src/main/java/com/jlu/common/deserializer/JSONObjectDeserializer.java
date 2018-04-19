package com.jlu.common.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.jlu.common.utils.JsonUtils;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

/**
 * Created by baidu on 15/11/18.
 */
public class JSONObjectDeserializer extends JsonDeserializer<JSONObject> {


    @Override
    public JSONObject deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JSONObject json = JsonUtils.getJsonObject(jp.readValueAsTree().toString());
        return json;
    }

}
