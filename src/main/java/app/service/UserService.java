package app.service;

import app.domain.User;
import app.repository.UserRepository;

public class UserService {

    public static User createOrGetUser (String login) {
    User user = UserRepository.getByLogin(login);
        if (user!=null) {
            return user;
        } else {
            UserRepository.add(new User(login));
            return UserRepository.getByLogin(login);
        }
    }





}
