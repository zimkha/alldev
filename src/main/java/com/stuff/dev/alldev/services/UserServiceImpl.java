package com.stuff.dev.alldev.services;

import com.stuff.dev.alldev.entities.Messages;
import com.stuff.dev.alldev.entities.Technology;
import com.stuff.dev.alldev.entities.User;
import com.stuff.dev.alldev.repositories.MessageRepository;
import com.stuff.dev.alldev.repositories.TechnologyRepository;
import com.stuff.dev.alldev.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private  final TechnologyRepository technologyRepository;
    private  final MessageRepository messageRepository;

    @Override
    public User created(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> list(int limit) {
        return userRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean deleted(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public Collection<Messages> listMessageByUser(Long id) {
        return messageRepository.findByUser(id);
    }


}
