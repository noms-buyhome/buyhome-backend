package com.ssafy.buyhome.home.controller;

import com.ssafy.buyhome.home.model.dto.HomeInfo;
import com.ssafy.buyhome.home.model.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeRestController {
    private final HomeService homeService;

    @GetMapping("/{dongcode}")
    public ResponseEntity<?> findByDongCode(@PathVariable("dongcode") String dongCode) {
        List<HomeInfo> list = homeService.findByDongCode(dongCode);
        //1111018300 이거가 제일 리스트 많이 나온당
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
