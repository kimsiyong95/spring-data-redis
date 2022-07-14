package com.kimsiyong.springdataredis.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final StringRedisTemplate stringRedisTemplate;


    public String findMember(String id){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();

        return stringStringValueOperations.get(id);
    }


    public String insertMember(Map param){
        return save(param);
    }


    public String save(Map param){
        stringRedisTemplate.opsForValue().set((String) param.get("id"), (String) param.get("name"),60, TimeUnit.SECONDS);
        return "OK";
    }


}
