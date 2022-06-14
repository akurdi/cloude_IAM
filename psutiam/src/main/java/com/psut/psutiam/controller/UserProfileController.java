package com.psut.psutiam.controller;


import com.psut.psutiam.data.UserProfile;
import com.psut.psutiam.db.entity.Role;
import com.psut.psutiam.exception.IamException;
import com.psut.psutiam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
//import io.swagger.annotations.Api;


@RestController
@RequestMapping("api/rest/iam/user")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "email/{email}")
    public ResponseEntity<UserProfile> getProfileByEmail(@PathVariable String email) throws RuntimeException {
        UserProfile profile = null;
        try {
            profile = userService.findUserProfileByEmail(email);
        } catch (IamException e) {
            throw new RuntimeException("No profile with this eamil " + email);
        }
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping(path = "uuid/{uuid}")
    public ResponseEntity<UserProfile> getProfileByUserId(@PathVariable String uuid) throws RuntimeException {
        UserProfile profile = null;
        try {
            profile = userService.findUserUUID(uuid);
        } catch (IamException e) {
            throw new RuntimeException("No profile with this uuid " + uuid);
        }
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    //Valid
    public ResponseEntity<UserProfile> save( /**@Valid**/@RequestBody UserProfile userProfileRequest) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserProfile userProfile = userService.saveUserProfile(userProfileRequest);
        return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    //Valid
    public ResponseEntity<UserProfile> update( /**@Valid**/@RequestBody UserProfile userProfileRequest) throws NoSuchAlgorithmException, InvalidKeySpecException, IamException {
        UserProfile userProfile = userService.updateUserProfile(userProfileRequest);
        return new ResponseEntity<>(userProfile, HttpStatus.CREATED);
    }

    @DeleteMapping("uuid/{uuid}")
    public ResponseEntity<Boolean> delete(@PathVariable String uuid) throws IamException {
        userService.deleteUserProfile(uuid);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
    }


    @GetMapping(path = "getByRole/{role}")
    public ResponseEntity<Collection<UserProfile>> getAllByRole(@PathVariable String role) throws RuntimeException, IamException {
        if (Role.Instructor.getLevel().equals(role)) {
            return new ResponseEntity(userService.findAllUserByRole(Role.Instructor), HttpStatus.OK);
        } else if (Role.Student.getLevel().equals(role)) {
            return new ResponseEntity(userService.findAllUserByRole(Role.Student), HttpStatus.OK);
        } else {
            throw new RuntimeException("this role " + role + " is not exist ");
        }
    }

    @GetMapping(path = "getByRoles")
    public ResponseEntity<List<String>> getAllByRole() throws RuntimeException, IamException {
        return new ResponseEntity<>(Arrays.asList(Role.values()).stream()
                .map(role -> role.getLevel()).collect(Collectors.toList()),
                HttpStatus.OK);
    }
}
