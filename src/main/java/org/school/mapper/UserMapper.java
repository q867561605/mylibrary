package org.school.mapper;


import java.util.List;

import org.school.model.User;

public interface UserMapper {
    int delete(String username);

    int insert(User record);

    User select(String username);
    
    List<User> selectAll();

    int update(User record);
}