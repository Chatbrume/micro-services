package fr.maximedzn.msuser.controller;

import fr.maximedzn.msuser.dto.SigninRequest;
import fr.maximedzn.msuser.dto.SignupRequest;
import fr.maximedzn.msuser.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody SignupRequest signupRequest) {
        authService.signup(signupRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody SigninRequest signinRequest) {
        return new ResponseEntity<>(authService.signin(signinRequest), HttpStatus.OK);
    }


}
