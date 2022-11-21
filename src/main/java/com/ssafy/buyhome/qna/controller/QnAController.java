package com.ssafy.buyhome.qna.controller;

import com.ssafy.buyhome.qna.model.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/qna")
@RequiredArgsConstructor
public class QnAController {

    private final QnaService qnaService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(qnaService.searchAll());
    }

    @GetMapping("/{qnaid}")
    public ResponseEntity<?> findById(@PathVariable("qnaid") Integer qnaId) {
        return ResponseEntity.ok(qnaService.findById(qnaId));
    }
}
