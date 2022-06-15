package fr.maximedzn.msuser.service;

import fr.maximedzn.msuser.dto.SigninRequest;
import fr.maximedzn.msuser.dto.SignupRequest;

public interface AuthService {

    String signin(SigninRequest signinRequest);
    void signup(SignupRequest signupRequest);
}
