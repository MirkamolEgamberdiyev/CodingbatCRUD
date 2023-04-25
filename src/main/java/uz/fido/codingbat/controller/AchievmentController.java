package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.entity.Achievment;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.service.AchievmentService;

@RestController
@RequestMapping("/api/achievment")
public class AchievmentController {

    @Autowired
    AchievmentService achievmentService;

    @PostMapping("/addAchievment")
    public HttpEntity<ApiResponce> addAchievment(@RequestBody Achievment achievment) {
        ApiResponce apiResponce = achievmentService.addAchievment(achievment);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneAchievment/{id}")
    public HttpEntity<ApiResponce> getOneAchievment(@PathVariable Integer id) {
        ApiResponce apiResponce = achievmentService.getOneAchievment(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllAchievment")
    public HttpEntity<ApiResponce> getAllAchievment() {
        ApiResponce apiResponce = achievmentService.getAllAchievment();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateAchievment/{id}")
    public HttpEntity<ApiResponce> updateAchievment(@PathVariable Integer id, @RequestBody Achievment achievment) {
        ApiResponce apiResponce = achievmentService.updateAchievment(id, achievment);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @DeleteMapping("/deleteAchievment/{id}")
    public HttpEntity<ApiResponce> deleteAchievment(@PathVariable Integer id) {
        ApiResponce apiResponce = achievmentService.deleteAchievment(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }
}

