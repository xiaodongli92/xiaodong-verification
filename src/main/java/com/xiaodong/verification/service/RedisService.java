package com.xiaodong.verification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * Created by lixiaodong on 16/8/25.
 */
@Service
public class RedisService {

    private static final String TEST_REDIS_KEY = "TEST_REDIS_KEY";

    @Qualifier("msgRedisTemplate")
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addZSet(String value, long score) {
        redisTemplate.opsForZSet().add(TEST_REDIS_KEY, value, score);
    }

    public Set<String> rangeByScoreZSet(long score) {
        return redisTemplate.opsForZSet().rangeByScore(TEST_REDIS_KEY, 0, score);
    }

    public void removeZSet(String value) {
        redisTemplate.opsForZSet().remove(TEST_REDIS_KEY, value);
    }
}
