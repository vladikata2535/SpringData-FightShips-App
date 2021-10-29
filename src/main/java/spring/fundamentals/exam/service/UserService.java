package spring.fundamentals.exam.service;

import spring.fundamentals.exam.models.entity.UserEntity;
import spring.fundamentals.exam.models.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel serviceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logoutUser();

    UserEntity findUserById(Long id);
}
