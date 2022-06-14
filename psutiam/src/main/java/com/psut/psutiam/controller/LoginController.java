package com.psut.psutiam.controller;


import com.psut.psutiam.data.LoginData;
import com.psut.psutiam.data.UserProfile;
import com.psut.psutiam.exception.IamException;
import com.psut.psutiam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("api/rest/iam/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserProfile> getByLogin( /**@Valid**/@RequestBody LoginData loginData) throws NoSuchAlgorithmException, InvalidKeySpecException, IamException {
        UserProfile userProfile = loginService.
                findUserProfileByEmailAndPassword(loginData.getUsername(), loginData.getPassword());
        return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
    }

    @PostMapping(path = "changePassword", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserProfile> changePassword( /**@Valid**/@RequestBody LoginData loginData) throws NoSuchAlgorithmException, InvalidKeySpecException, IamException {
        loginService.changePassword(loginData.getUsername(), loginData.getPassword(), loginData.getNewPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/isNewUser/email/{email}")
    public ResponseEntity<Boolean> getExamsByExaminerId(@PathVariable String email) throws IamException {
        return new ResponseEntity<Boolean>(loginService.isNew(email), HttpStatus.OK);
    }
}
