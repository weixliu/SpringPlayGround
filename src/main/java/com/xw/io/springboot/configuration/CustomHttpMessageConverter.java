package com.xw.io.springboot.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaowei.liu on 15/11/2017.
 *
 * I have a confused with this.
 */
@Slf4j
public class CustomHttpMessageConverter<T> implements HttpMessageConverter<T> {
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        log.info("-------canRead:{}, {}", aClass, mediaType);
        return true;
    }

    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        log.info("------canWrite:{}, {}", aClass, mediaType);
        return true;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Arrays.asList(MediaType.ALL);
    }

    @Override
    public T read(Class<? extends T> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        log.info("------read:{}, {}", aClass, httpInputMessage);
        return null;
    }

    @Override
    public void write(T t, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        log.info("------write:{}, {}, {}", t, mediaType, httpOutputMessage);
    }
}
