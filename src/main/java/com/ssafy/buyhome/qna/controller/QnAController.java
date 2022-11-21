package com.ssafy.buyhome.qna.controller;

import com.ssafy.buyhome.qna.model.dto.Question;
import com.ssafy.buyhome.qna.model.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Question question) {
        qnaService.create(question);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{qnaid}")
    public ResponseEntity<?> update(@RequestBody Question question, @PathVariable Integer qnaid) {
        qnaService.update(qnaid, question);
        return ResponseEntity.ok().build();
    }
}
