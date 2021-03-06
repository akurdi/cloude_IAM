package com.psut.psutiam.service.impl;


import com.psut.psutiam.data.UserProfile;
import com.psut.psutiam.db.entity.*;
import com.psut.psutiam.db.repo.IdentityRelRepo;
import com.psut.psutiam.db.repo.LoginRepo;
import com.psut.psutiam.db.repo.UserRepo;
import com.psut.psutiam.exception.IamException;
import com.psut.psutiam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private LoginRepo loginRepo;

    private IdentityRelRepo identityRelRepo;

    private PasswordServiceImpl passwordService;
//    private IdentityRelRepo identityRelRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, LoginRepo loginRepo, IdentityRelRepo identityRelRepo, PasswordServiceImpl passwordService) {
        this.userRepo = userRepo;
        this.loginRepo = loginRepo;
        this.identityRelRepo = identityRelRepo;
        this.passwordService = passwordService;
    }


    @Override
    public UserProfile findUserProfileByEmail(String email) throws IamException {
        User user = userRepo.findUserByEmail(email).orElseThrow(() -> new IamException("email not found"));
        return getUserProfile(user);
    }

    private UserProfile getUserProfile(User user) {
        return new UserProfile(user.getUuid(), user.getEmail(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole());
    }


    @Override
    public UserProfile findUserUUID(String UUID) throws IamException {
        User user = userRepo.findUserByUuid(UUID).orElseThrow(() -> new IamException("uuid not found"));
        return getUserProfile(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserProfile updateUserProfile(UserProfile userProfile) throws IamException {
        User user = userRepo.findUserByEmail(userProfile.getEmail()).orElseThrow(() -> new IamException("user not found"));
        user.setEmail(userProfile.getEmail());
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setRole(userProfile.getRole());
        user = userRepo.save(user);
        return getUserProfile(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUserProfile(String uuid) throws IamException {
        User user = userRepo.findUserByUuid(uuid).orElseThrow(() -> new IamException("user not found"));
        IdentityRel identityRel = identityRelRepo.findIdentityRelByIdentity1AndRelType(user, RelType.accessBy);
        identityRelRepo.delete(identityRel);
        Optional<Login> loginByUsername = loginRepo.findLoginByUsername(user.getEmail());
        loginRepo.delete(loginByUsername.get());
        userRepo.delete(user);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserProfile saveUserProfile(UserProfile userProfile) throws NoSuchAlgorithmException, InvalidKeySpecException {
        User user = new User();
        user.setEmail(userProfile.getEmail());
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setRole(userProfile.getRole());
        user = userRepo.save(user);

        Login login = new Login();
        login.setUsername(user.getEmail());
        login.setPassword(passwordService.getSaltedHashPassword("1234")); //todo chage it
        login = loginRepo.save(login);

        IdentityRel identityRel = new IdentityRel();
        identityRel.setIdentity1(user);
        identityRel.setIdentity2(login);
        identityRel.setRelType(RelType.accessBy);
        identityRelRepo.save(identityRel);
        return getUserProfile(user);
    }

    @Override
    public Collection<UserProfile> findAllUserByRole(Role role) throws IamException {
        if (role.equals(Role.Admin)) throw new IamException("You can not get all Admin");
        Iterable<User> usersByRole = userRepo.findUsersByRole(role);
        return StreamSupport.stream(usersByRole.spliterator(), false).map(user -> getUserProfile(user)).collect(Collectors.toList());
    }
}
