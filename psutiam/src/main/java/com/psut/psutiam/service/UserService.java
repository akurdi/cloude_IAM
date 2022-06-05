package com.psut.psutiam.service;


import com.psut.psutiam.data.UserProfile;
import com.psut.psutiam.db.entity.Role;
import com.psut.psutiam.exception.IamException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;


public interface UserService {

    UserProfile findUserProfileByEmail(String email) throws IamException;

    UserProfile findUserUUID(String UUID) throws IamException;

    UserProfile saveUserProfile(UserProfile userProfile) throws NoSuchAlgorithmException, InvalidKeySpecException;

    Collection<UserProfile> findAllUserByRole(Role role) throws IamException;
}
