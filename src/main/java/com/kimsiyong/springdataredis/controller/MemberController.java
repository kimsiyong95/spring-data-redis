package com.kimsiyong.springdataredis.controller;

import com.kimsiyong.springdataredis.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/{id}")
    public ResponseEntity findMember(@PathVariable("id") String id){

        return ResponseEntity.status(HttpStatus.OK).body(memberService.findMember(id));
    }

    @PostMapping("/members")
    public ResponseEntity insertMember(@RequestBody Map paramMap){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.insertMember(paramMap));
    }



}
