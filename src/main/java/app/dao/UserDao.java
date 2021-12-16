package app.dao;

import app.domain.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAll();

    User getBuId(int id);

    void update(User user);

    void remove(User user);
}
