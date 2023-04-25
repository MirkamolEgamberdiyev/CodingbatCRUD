package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.LanguageDto;
import uz.fido.codingbat.service.LanguageService;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @PostMapping("/addLanguage")
    public HttpEntity<ApiResponce> addLanguage(@RequestBody LanguageDto languageDto) {
        ApiResponce apiResponce = languageService.addLanguage(languageDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneLanguage/{id}")
    public HttpEntity<ApiResponce> getOneLanguage(@PathVariable Integer id) {
        ApiResponce apiResponce = languageService.getOneLanguage(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllLanguage")
    public HttpEntity<ApiResponce> getAllLanguage() {
        ApiResponce apiResponce = languageService.getAllLanguage();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateLanguage/{id}")
    public HttpEntity<ApiResponce> updateLanguage(@PathVariable Integer id, @RequestBody LanguageDto languageDto) {
        ApiResponce apiResponce = languageService.updateLanguage(languageDto, id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteLanguage/{id}")
    public HttpEntity<ApiResponce> deleteLanguage(@PathVariable Integer id) {
        ApiResponce apiResponce = languageService.deleteLanguage(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }



}
