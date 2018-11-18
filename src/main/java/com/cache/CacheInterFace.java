package com.cache;

public interface CacheInterFace {


    Boolean add(String key,Object value);

    void delete(String key);

    Boolean update(String key,Object o);

    Object selectOne(String key);
}
