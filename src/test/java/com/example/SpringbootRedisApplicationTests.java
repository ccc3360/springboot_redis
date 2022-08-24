package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;//key换了格式,未指定泛型
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void setget() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("age",41);
        Object age = valueOperations.get("age");
        System.out.println(age);
    }

    @Test
    void Hsetget() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info","a","aa");
        System.out.println(hashOperations.get("info","a"));
    }

    @Test
    void Ssetget() {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String name = stringStringValueOperations.get("name");
        System.out.println(name);
//        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
//        stringObjectObjectHashOperations.put("bbb","bb","b");
    }

}
