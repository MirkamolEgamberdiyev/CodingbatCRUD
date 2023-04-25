package uz.fido.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.codingbat.payload.ApiResponce;
import uz.fido.codingbat.payload.UserDto;
import uz.fido.codingbat.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public HttpEntity<ApiResponce> addUser(@RequestBody UserDto userDto) {
        ApiResponce apiResponce = userService.addUser(userDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneUser/{id}")
    public HttpEntity<ApiResponce> getOneUser(@PathVariable Integer id) {
        ApiResponce apiResponce = userService.getOneUser(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllUser")
    public HttpEntity<ApiResponce> getAllUser() {
        ApiResponce apiResponce = userService.getAllUser();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateUser/{id}")
    public HttpEntity<ApiResponce> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        ApiResponce apiResponce = userService.updateUser(id, userDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteUser/{id}")
    public HttpEntity<ApiResponce> deleteUser(@PathVariable Integer id) {
        ApiResponce apiResponce = userService.deleteUser(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
