package com.ssafy.buyhome.qna.controller;

import com.ssafy.buyhome.qna.model.dto.Answer;
import com.ssafy.buyhome.qna.model.dto.Question;
import com.ssafy.buyhome.qna.model.service.QnaService;
import com.ssafy.buyhome.qna.model.service.QuestionVoteService;
import com.ssafy.buyhome.user.model.exception.UserNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.ssafy.buyhome.util.RequestUtil.getUsernameFromRequest;

@RestController
@RequestMapping("/board/qna")
@RequiredArgsConstructor
public class QnAController {

    private final QnaService qnaService;
    private final QuestionVoteService questionVoteService;

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
    public ResponseEntity<?> update(@PathVariable("qnaid") Integer qnaId, @RequestBody Question question, HttpServletRequest request) {
        String requestedUsername = getUsernameFromRequest(request);
        if (!requestedUsername.equals(question.getAuthor().getUsername())) throw new UserNotAllowedException();

        qnaService.update(qnaId, question);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{qnaid}")
    public ResponseEntity<?> create(@PathVariable("qnaid") Integer qnaId, @RequestBody Answer answer) {
        qnaService.createAnswerToQuestion(answer, qnaId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{qnaid}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("qnaid") Integer qnaId, HttpServletRequest request) {
        Question question = qnaService.findById(qnaId);
        String requestedUsername = getUsernameFromRequest(request);
        if (!requestedUsername.equals(question.getAuthor().getUsername())) throw new UserNotAllowedException();

        qnaService.deleteQuestion(qnaId);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{qnaid}/answers/{answerid}")
    public ResponseEntity<?> updateAnswer(@PathVariable("answerid") Integer answerId, @RequestBody Answer answer, HttpServletRequest request) {
        String requestedUsername = getUsernameFromRequest(request);
        if (!requestedUsername.equals(answer.getAuthor().getUsername())) throw new UserNotAllowedException();

        qnaService.updateAnswer(answerId, answer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{qnaid}/answers/{answerid}")
    public ResponseEntity<?> deleteAnswer(@PathVariable("answerid") Integer answerId, HttpServletRequest request) {
        Answer answer = qnaService.findAnswerById(answerId);
        String requestedUsername = getUsernameFromRequest(request);
        if (!requestedUsername.equals(answer.getAuthor().getUsername())) throw new UserNotAllowedException();

        qnaService.deleteAnswer(answerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{qnaId}")
    public ResponseEntity<?> createAnswer(@RequestBody Answer answer, @PathVariable Integer qnaId) {
        qnaService.createAnswerToQuestion(answer, qnaId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{qnaid}/vote")
    public ResponseEntity<Void> vote(@PathVariable("qnaid") Integer qnaId, HttpServletRequest request) {
        questionVoteService.vote(qnaId, getUsernameFromRequest(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{qnaid}/vote")
    public ResponseEntity<Void> unvote(@PathVariable("qnaid") Integer qnaId, HttpServletRequest request) {
        questionVoteService.unvote(qnaId, getUsernameFromRequest(request));
        return ResponseEntity.ok().build();
    }
}
