package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.ProfileDto;
import uz.fido.codingbat.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping("/addProfile")
    public HttpEntity<ApiResponce> addProfile(@RequestBody ProfileDto profileDto) {
        ApiResponce apiResponce = profileService.addProfile(profileDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneProfile/{id}")
    public HttpEntity<ApiResponce> getOneProfile(@PathVariable Integer id) {
        ApiResponce apiResponce = profileService.getOneProfile(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllProfile")
    public HttpEntity<ApiResponce> getAllProfile() {
        ApiResponce apiResponce = profileService.getAllProfile();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateProfile/{id}")
    public HttpEntity<ApiResponce> updateProfile(@PathVariable Integer id, @RequestBody ProfileDto profileDto) {
        ApiResponce apiResponce = profileService.updateProfile(id, profileDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteProfile/{id}")
    public HttpEntity<ApiResponce> deleteProfile(@PathVariable Integer id) {
        ApiResponce apiResponce = profileService.deleteProfile(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);

    }
}
