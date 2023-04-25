package uz.fido.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.codingbat.entity.Quiz;
import uz.fido.codingbat.entity.Task;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.TaskDto;
import uz.fido.codingbat.repository.QuizRepository;
import uz.fido.codingbat.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    QuizRepository quizRepository;

    public ApiResponce addTask(TaskDto taskDto) {
        Task task = new Task();
        task.setQuestion(taskDto.getQuestion());
        Optional<Quiz> optionalQuiz = quizRepository.findById(taskDto.getQuiz_id());
        if (!optionalQuiz.isPresent())
            return new ApiResponce("Bunday quiz mavjud emas", false);
        Quiz quiz = optionalQuiz.get();
        task.setQuiz(quiz);
        Task save = taskRepository.save(task);
        return new ApiResponce("task qo'shildi", true, save);
    }

    public ApiResponce getOneTask(Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent())
            return new ApiResponce("Bunday task mavjud emas", false);

        Task task = optionalTask.get();
        return new ApiResponce("Task topilidi", true, task);
    }

    public ApiResponce getAllTask() {
        List<Task> tasks = taskRepository.findAll();
        return new ApiResponce("tasklar listi topildi", true, tasks);
    }

    public ApiResponce updateTask(Integer id, TaskDto taskDto) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent())
            return new ApiResponce("task topilmadi", false);
        Task task = optionalTask.get();
        task.setQuestion(taskDto.getQuestion());
        Optional<Quiz> optionalQuiz = quizRepository.findById(taskDto.getQuiz_id());
        if (!optionalQuiz.isPresent())
            return new ApiResponce("Bunday quiz mavjud emas", false);
        Quiz quiz = optionalQuiz.get();
        task.setQuiz(quiz);
        Task save = taskRepository.save(task);
        return new ApiResponce("task update qilindi", true, save);

    }

    public ApiResponce deleteTask(Integer id) {
        taskRepository.deleteById(id);
        return new ApiResponce("task o'chirildi", true);
    }
}
