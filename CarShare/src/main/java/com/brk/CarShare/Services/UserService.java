package com.brk.CarShare.Services;

import com.brk.CarShare.Entities.User;
import com.brk.CarShare.Repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final IUserRepository userRepository;
    public void addUser(User user) {userRepository.insert(user);}
    public List<User> getAllUsers() {return userRepository.findAll();}
    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Cannot Find User by ID - %s", id)));
    }
    public void updateUser(User user){
        User savedUser = userRepository.findById(user.getUserID()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Vehicle by ID %s", user.getUserID())));
        savedUser.setUserID(user.getUserID());
        savedUser.setRoleID(user.getRoleID());
        savedUser.setDriverLicenceNo(user.getDriverLicenceNo());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setCountry(user.getCountry());
        savedUser.setCity(user.getCity());
        savedUser.setAddress(user.getAddress());
        savedUser.setPhoneNo(user.getPhoneNo());
        savedUser.setJoinDate(user.getJoinDate());
        savedUser.setSubscriptionTier(user.getSubscriptionTier());
        savedUser.setBillingCycle(user.getBillingCycle());
    }
    public void deleteUser(String userId) {userRepository.deleteById(userId);}
}
