package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.ToplearnersDto;
import uz.fido.codingbat.service.ToplearnersService;

@RestController
@RequestMapping("/api/toplearners")
public class ToplearnersController {
    @Autowired
    ToplearnersService toplearnersService;

    @PostMapping("/addToplearners")
    public HttpEntity<ApiResponce> addToplearners(@RequestBody ToplearnersDto toplearnersDto) {
        ApiResponce apiResponce = toplearnersService.addToplearners(toplearnersDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneToplearners/{id}")
    public HttpEntity<ApiResponce> getOneToplearners(@PathVariable Integer id) {
        ApiResponce apiResponce = toplearnersService.getOneToplearners(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllToplearners")
    public HttpEntity<ApiResponce> getAllToplearners() {
        ApiResponce apiResponce = toplearnersService.getAllToplearners();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateToplearners/{id}")
    public HttpEntity<ApiResponce> updateToplearners(@PathVariable Integer id, @RequestBody ToplearnersDto toplearnersDto) {
        ApiResponce apiResponce = toplearnersService.updateToplearners(id, toplearnersDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteToplearners/{id}")
    public HttpEntity<ApiResponce> deleteToplearners(@PathVariable Integer id) {
        ApiResponce apiResponce = toplearnersService.deleteToplearners(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
