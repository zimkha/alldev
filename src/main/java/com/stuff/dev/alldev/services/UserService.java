package com.stuff.dev.alldev.services;


import com.stuff.dev.alldev.entities.Messages;
import com.stuff.dev.alldev.entities.Technology;
import com.stuff.dev.alldev.entities.User;

import java.util.Collection;

public interface UserService {
  User created(User user);
  Collection<User> list (int limit);
  User get(Long id);
  User update(User user);
  Boolean deleted(Long id);
  Collection<Messages> listMessageByUser(Long id);
}
