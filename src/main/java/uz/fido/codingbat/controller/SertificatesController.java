package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.entity.Sertificates;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.service.SertificatesService;

@RestController
@RequestMapping("/api/sertificates")
public class SertificatesController {

    @Autowired
    SertificatesService sertificatesService;

    @PostMapping("/addSertificates")
    public HttpEntity<ApiResponce> addSertificates(@RequestBody Sertificates sertificates) {
        ApiResponce apiResponce = sertificatesService.addSertificates(sertificates);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneSertificates/{id}")
    public HttpEntity<ApiResponce> getOneSertificates(@PathVariable Integer id) {
        ApiResponce apiResponce = sertificatesService.getOneSertificates(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllSertificates")
    public HttpEntity<ApiResponce> getAllSertificates() {
        ApiResponce apiResponce = sertificatesService.getAllSertificates();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }

    @PutMapping("/updateSertificates/{id}")
    public HttpEntity<ApiResponce> updateSertificates(@PathVariable Integer id, @RequestBody Sertificates sertificates) {
        ApiResponce apiResponce = sertificatesService.updateSertificates(id, sertificates);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteSertificates/{id}")
    public HttpEntity<ApiResponce> deleteSertificates(@PathVariable Integer id) {
        ApiResponce apiResponce = sertificatesService.deleteSertificates(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


}
