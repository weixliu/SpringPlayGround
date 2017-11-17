package com.xw.io.springboot.beans;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.io.IOException;

/**
 * Created by xiaowei.liu on 16/11/2017.
 * How we use that?
 * What's MessageCodesResolver?
 */
public class CustomJsonDeserializer<T> extends JsonObjectDeserializer<T> {

    @Override
    protected T deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectCodec objectCodec, JsonNode jsonNode) throws IOException {
        return null;
    }
}
