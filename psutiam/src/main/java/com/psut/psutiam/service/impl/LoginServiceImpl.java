package com.psut.psutiam.service.impl;

import com.psut.psutiam.data.UserProfile;
import com.psut.psutiam.db.entity.Login;
import com.psut.psutiam.db.repo.LoginRepo;
import com.psut.psutiam.db.repo.UserRepo;
import com.psut.psutiam.exception.IamException;
import com.psut.psutiam.service.LoginService;
import com.psut.psutiam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private LoginRepo loginRepo;
    private PasswordServiceImpl passwordService;
    private UserService userService;

    @Autowired
    public LoginServiceImpl(LoginRepo loginRepo, PasswordServiceImpl passwordService, UserService userService) {
        this.loginRepo = loginRepo;
        this.passwordService = passwordService;
        this.userService = userService;
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        try {
            UserProfile userProfileByEmailAndPassword = findUserProfileByEmailAndPassword(username, oldPassword);
            Optional<Login> loginByUsername = loginRepo.findLoginByUsername(userProfileByEmailAndPassword.getUsername());
            Login login = loginByUsername.get();
            String saltedHashPassword = passwordService.getSaltedHashPassword(newPassword);
            login.setPassword(saltedHashPassword);
            loginRepo.save(login);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (IamException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserProfile findUserProfileByEmailAndPassword(String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, IamException {
        Login login = loginRepo.findLoginByUsername(email).orElseThrow(() -> new IamException("email not found"));
        if (!passwordService.isEquals(password, login.getPassword())) {
            throw new IamException("password not match");
        } else {
            return userService.findUserProfileByEmail(email);
        }
    }
}
