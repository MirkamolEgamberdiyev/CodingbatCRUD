package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.entity.Quiz;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/addQuiz")
    public HttpEntity<ApiResponce> addQuiz(@RequestBody Quiz quiz) {
        ApiResponce apiResponce = quizService.addQuiz(quiz);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneQuiz/{id}")
    public HttpEntity<ApiResponce> getOneQuiz(@PathVariable Integer id) {
        ApiResponce apiResponce = quizService.getOneQuiz(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllQuiz")
    public HttpEntity<ApiResponce> getAllQuiz() {
        ApiResponce apiResponce = quizService.getAllQuiz();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
    @PutMapping("/updateQuiz/{id}")
    public HttpEntity<ApiResponce> updateQuiz(@PathVariable Integer id, @RequestBody Quiz quiz) {
        ApiResponce apiResponce = quizService.updateQuiz(quiz, id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteQuiz/{id}")
    public HttpEntity<ApiResponce> updateQuiz(@PathVariable Integer id) {
        ApiResponce apiResponce = quizService.deleteQuiz(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

}
