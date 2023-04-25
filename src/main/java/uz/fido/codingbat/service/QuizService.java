package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Quiz;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    public ApiResponce addQuiz(Quiz quiz) {
        boolean existsByName = quizRepository.existsByName(quiz.getName());
        if (existsByName)
            return new ApiResponce("Bunday quiz mavjud!", false);
        Quiz save = quizRepository.save(quiz);
        return new ApiResponce("quiz qo'shildi", true, save);
    }

    public ApiResponce getOneQuiz(Integer id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (!optionalQuiz.isPresent())
            return new ApiResponce("Bunday quiz mavjud emas!", false);
        Quiz quiz = optionalQuiz.get();
        return new ApiResponce("Quiz topildi", true, quiz);
    }

    public ApiResponce getAllQuiz() {
        List<Quiz> quizList = quizRepository.findAll();
        return new ApiResponce("Quiz topildi", true, quizList);
    }

    public ApiResponce updateQuiz(Quiz quiz, Integer id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (!optionalQuiz.isPresent())
            return new ApiResponce("Bunday quiz mavjud emas", false);
        Quiz quiz1 = optionalQuiz.get();
        quiz1.setName(quiz.getName());
        Quiz save = quizRepository.save(quiz1);
        return new ApiResponce("quzi update qilindi", true, save);
    }

    public ApiResponce deleteQuiz(Integer id) {
        quizRepository.deleteById(id);
        return new ApiResponce("quiz o'chirildi", true);
    }

}
