package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.PhotoDto;
import uz.fido.codingbat.service.PhotoService;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @PostMapping("/addPhoto")
    public HttpEntity<ApiResponce> addPhoto(@RequestBody PhotoDto photoDto) {
        ApiResponce apiResponce = photoService.addPhoto(photoDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


    @GetMapping("/getOnePhoto/{id}")
    public HttpEntity<ApiResponce> getOnePhoto(@PathVariable Integer id) {
        ApiResponce apiResponce = photoService.getOnePhoto(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllPhoto")
    public HttpEntity<ApiResponce> getAllPhoto() {
        ApiResponce apiResponce = photoService.getAllPhoto();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updatePhoto/{id}")
    public HttpEntity<ApiResponce> updatePhoto(@PathVariable Integer id, @RequestBody PhotoDto photoDto) {
        ApiResponce apiResponce = photoService.updatePhoto(id, photoDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
    @DeleteMapping("/deletePhoto/{id}")
    public HttpEntity<ApiResponce> deletePhoto(@PathVariable Integer id) {
        ApiResponce apiResponce = photoService.deletePhoto(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }
}
