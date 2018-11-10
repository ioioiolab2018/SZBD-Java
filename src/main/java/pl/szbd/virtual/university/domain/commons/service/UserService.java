package pl.szbd.virtual.university.domain.commons.service;

import pl.szbd.virtual.university.domain.commons.model.entities.User;

public interface UserService {
    public User findUserByUsername(String username);

    public boolean deleteUserByUsername(String username);

    public User saveUser(User user);
}
