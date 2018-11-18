package com.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheImpl implements CacheInterFace {

   @Autowired
   private RedisUtil redisUtil;



    @Override
    public Boolean add(String key, Object value) {
        return   redisUtil.set(key, value);

    }

    @Override
    public void delete(String key) {
         redisUtil.remove(key);
    }

    @Override
    public Boolean update(String key, Object o) {
        return redisUtil.set(key, o);
    }


    @Override
    public Object selectOne(String key) {
        return redisUtil.get(key);
    }


}
