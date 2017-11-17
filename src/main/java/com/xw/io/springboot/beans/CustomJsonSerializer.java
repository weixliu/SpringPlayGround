package com.xw.io.springboot.beans;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;


/**
 * Created by xiaowei.liu on 16/11/2017.
 * How we use that?
 */
public class CustomJsonSerializer<T> extends JsonObjectSerializer<T> {

    @Override
    protected void serializeObject(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
       jsonGenerator.writeStringField("t", t.toString());
    }

}
