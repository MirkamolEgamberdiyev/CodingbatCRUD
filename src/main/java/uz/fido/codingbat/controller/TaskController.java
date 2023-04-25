package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.TaskDto;
import uz.fido.codingbat.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/addTask")
    public HttpEntity<ApiResponce> addTask(@RequestBody TaskDto taskDto) {
        ApiResponce apiResponce = taskService.addTask(taskDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneTask/{id}")
    public HttpEntity<ApiResponce> getOneTask(@PathVariable Integer id) {
        ApiResponce apiResponce = taskService.getOneTask(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getALlTask")
    public HttpEntity<ApiResponce> getAllTask() {
        ApiResponce apiResponce = taskService.getAllTask();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateTask/{id}")
    public HttpEntity<ApiResponce> updateTask(@PathVariable Integer id, @RequestBody TaskDto taskDto) {
        ApiResponce apiResponce = taskService.updateTask(id, taskDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteTask/{id}")
    public HttpEntity<ApiResponce> deleteTask(@PathVariable Integer id) {
        ApiResponce apiResponce = taskService.deleteTask(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
