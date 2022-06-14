package com.psut.psutiam.service;

import com.psut.psutiam.data.UserProfile;
import com.psut.psutiam.exception.IamException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface LoginService {

    UserProfile findUserProfileByEmailAndPassword(String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, IamException;
    void changePassword(String username, String oldPassword, String newPassword);

    boolean isNew(String email) throws IamException;
}
