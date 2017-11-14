/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: zhoumaowang<zhou_mw@suixingpay.com>
 * @date: 2017/3/22 上午11:01
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.mybatis.core.redis;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description: redis 公共service
 * @author: john.lee
 * @date: 2017/3/22 上午11:01
 * @version: V1.0
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    /**
     * 获取缓存值
     * @param cacheKey
     * @return
     */
    public Object getCacheValue(String cacheKey) {
        return redisTemplate.opsForValue().get(cacheKey);
    }

    /**
     * 设置缓存值
     * @param key
     * @param value
     */
    public void setCacheValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置多组缓存值
     * @param
     */
    public void setMultiCacheValue(Map<String, Object> redisMap) {
        redisTemplate.opsForValue().multiSet(redisMap);
    }

    /**
     * 设置缓存值并设置有效期
     * @param key
     * @param value
     */
    public void setCacheValueForTime(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 设置缓存值并设置有效期
     * @param key
     * @param value
     */
    public void setCacheValueForHour(String cacheKey, Object value, int hour) {
        redisTemplate.opsForValue().set(cacheKey, value, hour, TimeUnit.HOURS);
    }
    
    /**
     * 设置缓存值并设置有效期
     * @param key
     * @param value
     */
    public void setCacheValueForMinute(String cacheKey, Object value, int minutes) {
        redisTemplate.opsForValue().set(cacheKey, value, minutes, TimeUnit.MINUTES);
    }
    
    /**
     * 删除key值
     * @param key
     */
    public void delCacheByKey(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
//      redisTemplate.opsForHash().delete(key);
    }

    /**
     * 删除keys值
     * @param keys
     */
    public void delCacheByKey(Set<String> keys) {
        redisTemplate.opsForValue().getOperations().delete(keys);
    }
    /**
     * 获取token的有效期
     * @param key
     */
    public long getExpireTime(String key) {
        long time = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return time;
    }

    /**
     * 设置token的有效期
     * @param key
     * @return
     */
    public boolean setExpireTime(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }



}


