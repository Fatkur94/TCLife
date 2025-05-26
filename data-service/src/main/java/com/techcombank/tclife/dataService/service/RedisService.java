package com.techcombank.tclife.dataService.service;

import java.time.Duration;

public interface RedisService {

    void saveData(String key, Object value, Duration ttl);

    void saveData(String key, Object value);

    <T> T getData(String key, Class<T> clazz);

    boolean exists(String key);

    void deleteData(String key);

    void saveOrUpdate(String key, Object value, Duration ttl);

    Object getObjectByKey(String key);
}

