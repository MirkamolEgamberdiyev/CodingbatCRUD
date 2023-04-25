package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.SololearnDto;
import uz.fido.codingbat.service.SololearnService;

@RestController
@RequestMapping("/api/sololearn")
public class SololearnController {
    @Autowired
    SololearnService sololearnService;
    @PostMapping("/addSololearn")
    public HttpEntity<ApiResponce> addSololearn(@RequestBody SololearnDto sololearnDto) {
        ApiResponce apiResponce = sololearnService.addSololearn(sololearnDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getSololearn/{id}")
    public HttpEntity<ApiResponce> getSololearn(@PathVariable Integer id) {
        ApiResponce apiResponce = sololearnService.getOneSololearn(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllSololearn")
    public HttpEntity<ApiResponce> getAllSololearn() {
        ApiResponce apiResponce = sololearnService.getAllSololearn();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateSololearn/{id}")
    public HttpEntity<ApiResponce> updateSololearn(@PathVariable Integer id, @RequestBody SololearnDto sololearnDto) {
        ApiResponce apiResponce = sololearnService.updateSololearn(id, sololearnDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteSololearn/{id}")
    public HttpEntity<ApiResponce> deleteSololearn(@PathVariable Integer id) {
        ApiResponce apiResponce = sololearnService.deleteSololearn(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

}
